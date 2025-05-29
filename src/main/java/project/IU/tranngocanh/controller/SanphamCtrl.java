package project.IU.tranngocanh.controller;

import org.springframework.web.bind.annotation.*;
import project.IU.tranngocanh.entity.Sanpham;
import project.IU.tranngocanh.service.SanphamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
public class SanphamCtrl {
    @Autowired
    private SanphamService spService;

    @GetMapping
    public List<Sanpham> getAll() {
        return spService.getAll();
    }

    @PostMapping
    public Sanpham createSp(@RequestBody Sanpham sp) {
        return spService.createSanpham(sp);
    }

    @DeleteMapping
    public Sanpham delete(@PathVariable String id) {
        return spService.deleteSanpham(id);
    }

    @PutMapping("/{id}")
    public Sanpham updateSp(@PathVariable String id, @RequestBody Sanpham sp) {
        return spService.updateSanpham(id, sp);
    }

}
