package project.IU.tranngocanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.IU.tranngocanh.entity.Student;
import project.IU.tranngocanh.service.ExcelImportService;

import java.io.IOException;
import java.util.List;
import java.util.Map; // Để trả về message đơn giản

@RestController
@RequestMapping("/api/students")
public class StudentImportController {

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadStudentsData(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Vui lòng chọn một file Excel."));
        }

        // Kiểm tra loại file (chỉ chấp nhận Excel) - Tùy chọn
        String contentType = file.getContentType();
        if (contentType == null ||
                (!contentType.equals("application/vnd.ms-excel") && // .xls
                        !contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) { // .xlsx
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                    .body(Map.of("message", "Chỉ chấp nhận file Excel (.xls hoặc .xlsx)."));
        }

        try {
            List<Student> importedStudents = excelImportService.importStudentsFromExcel(file);
            if (importedStudents.isEmpty()) {
                return ResponseEntity.ok(Map.of("message", "Không có dữ liệu sinh viên mới nào được import hoặc file rỗng."));
            }
            return ResponseEntity.ok(Map.of(
                    "message", "Đã import thành công " + importedStudents.size() + " sinh viên.",
                    "data", importedStudents
            ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Lỗi khi đọc file Excel: " + e.getMessage()));
        } catch (Exception e) {
            // Bắt các lỗi khác, ví dụ lỗi từ CSDL hoặc logic nghiệp vụ
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Lỗi không xác định trong quá trình import: " + e.getMessage()));
        }
    }

    // Endpoint để lấy tất cả sinh viên (kiểm tra)
    @Autowired
    private  project.IU.tranngocanh.repository.StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
}