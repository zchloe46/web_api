package project.IU.tranngocanh.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.IU.tranngocanh.dto.sinhvien.SinhVienCreateRequest;
import project.IU.tranngocanh.entity.SinhVien;
import project.IU.tranngocanh.service.SinhvienService;


@RestController
@RequestMapping("/api/sinhvien")
public class SinhvienCtrl {
    @Autowired
    private SinhvienService sinhVienService;

    @GetMapping
    public List<SinhVien> getAllSinhVien() {
        return sinhVienService.getAllSinhVien();
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVienById(@PathVariable String id) {
        return sinhVienService.getSinhVienById(id);
    }

    @GetMapping("/{lop}")
    public List<SinhVien> getSinhVienByLop(@PathVariable String lop) {
        return sinhVienService.getSinhVienByLop(lop);
    }

    @GetMapping("/{hoten}")
    public List<SinhVien> getSinhVienByHoten(@PathVariable String hoten) {
        return sinhVienService.getSinhVienByHoten(hoten);
    }

    @PostMapping
    public SinhVien createSinhVien(@RequestBody SinhVienCreateRequest sinhVienCreateRequest) {
        return sinhVienService.themSinhVien(sinhVienCreateRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteSinhVien(@PathVariable String id) {
        sinhVienService.deleteSinhVien(id);
        return "Delete sinh vien successfully";
    }

    @PutMapping("/{id}")
    public String updateSinhVien(@PathVariable String id, @RequestBody SinhVienCreateRequest sinhVienCreateRequest) {
        sinhVienService.updateSinhVien(id, sinhVienCreateRequest);
        return "Update sinh vien successfully";
    }

}
