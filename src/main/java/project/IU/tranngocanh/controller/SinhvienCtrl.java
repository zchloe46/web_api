package project.IU.tranngocanh.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{lop}")
    public List<SinhVien> getSinhVienByLop(@PathVariable String lop) {
        return sinhVienService.getSinhVienByLop(lop);
    }

    @GetMapping("/{hoten}")
    public List<SinhVien> getSinhVienByHoten(@PathVariable String hoten) {
        return sinhVienService.getSinhVienByHoten(hoten);
    }

    @PostMapping
    public SinhVien creatSinhVien(@RequestBody SinhVienCreateRequest sinhVienCreateRequest) {
        return sinhVienService.themSinhVien(sinhVienCreateRequest);
    }
}
