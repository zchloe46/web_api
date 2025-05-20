package project.IU.tranngocanh.service;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // Cho .xlsx
// import org.apache.poi.hssf.usermodel.HSSFWorkbook; // Cho .xls cũ
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.IU.tranngocanh.entity.Student;
import project.IU.tranngocanh.repository.StudentRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelImportService {

    @Autowired
    private StudentRepository studentRepository;

    public static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Hoặc định dạng lại nếu cần
                } else {
                    // Xử lý cẩn thận số dưới dạng String để tránh dạng khoa học (ví dụ: 1.23E4)
                    // Nếu Mã SV là số, nên đọc nó như String
                    DataFormatter formatter = new DataFormatter();
                    return formatter.formatCellValue(cell);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula(); // Hoặc tính giá trị công thức: cell.getStringCellValue()
            default:
                return "";
        }
    }

    @Transactional // Đảm bảo tất cả lưu hoặc không lưu gì cả
    public List<Student> importStudentsFromExcel(MultipartFile file) throws IOException {
        List<Student> students = new ArrayList<>();
        InputStream inputStream = file.getInputStream();

        // Sử dụng XSSFWorkbook cho .xlsx, HSSFWorkbook cho .xls
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

        Iterator<Row> rowIterator = sheet.iterator();

        // Bỏ qua dòng header (nếu có)
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            Student student = new Student();

            // Giả sử cột trong Excel:
            // Cột 0: Student ID
            // Cột 1: Name
            // Cột 2: Email
            // Cột 3: Major

            Cell studentIdCell = currentRow.getCell(0);
            Cell nameCell = currentRow.getCell(1);
            Cell emailCell = currentRow.getCell(2);
            Cell majorCell = currentRow.getCell(3);

            // Kiểm tra xem dòng có rỗng không bằng cách kiểm tra ô quan trọng (ví dụ: studentId)
            if (studentIdCell == null || getCellValueAsString(studentIdCell).trim().isEmpty()) {
                continue; // Bỏ qua dòng rỗng
            }

            student.setStudentId(getCellValueAsString(studentIdCell).trim());
            student.setName(getCellValueAsString(nameCell).trim());
            student.setEmail(getCellValueAsString(emailCell).trim());
            student.setMajor(getCellValueAsString(majorCell).trim());

            // Tùy chọn: Kiểm tra xem sinh viên đã tồn tại chưa trước khi thêm
            // Optional<Student> existingStudent = studentRepository.findByStudentId(student.getStudentId());
            // if (existingStudent.isPresent()) {
            //     // Xử lý logic cập nhật hoặc bỏ qua
            //     System.out.println("Sinh viên " + student.getStudentId() + " đã tồn tại, bỏ qua.");
            //     continue;
            // }

            students.add(student);
        }
        workbook.close();
        inputStream.close();

        if (!students.isEmpty()) {
            return studentRepository.saveAll(students); // Lưu tất cả sinh viên vào CSDL
        }
        return new ArrayList<>(); // Trả về danh sách rỗng nếu không có gì để import
    }
}