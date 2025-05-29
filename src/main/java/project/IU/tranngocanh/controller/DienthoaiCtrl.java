package project.IU.tranngocanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.IU.tranngocanh.dto.dienthoai.DienthoaiCreationRequest;
import project.IU.tranngocanh.dto.dienthoai.DienthoaiUpdateRequest;
import project.IU.tranngocanh.entity.Dienthoai;
import project.IU.tranngocanh.service.DienthoaiService;

import java.util.List;

@RestController
@RequestMapping("/api/dienthoai")
public class DienthoaiCtrl {
    @Autowired
    private DienthoaiService dtSer;

    @GetMapping
    public List<Dienthoai> getAllDt() {
        return dtSer.getAll();
    }

    @GetMapping("/{tenDienThoai}")
    public List<Dienthoai> getDtByTen(@PathVariable String tenDienThoai) {
        return dtSer.getDtByTen(tenDienThoai);
    }

    @GetMapping("/dongia/{donGia}")
    public List<Dienthoai> getDtByDonGiaLessThanEqual(@PathVariable double donGia) {
        return dtSer.getDtByDonGiaLessThanEqual(donGia);
    }

    @PostMapping
    public Dienthoai addDt(@RequestBody DienthoaiCreationRequest dt) {
        return dtSer.createDt(dt);
    }

    @PutMapping("/{id}")
    public Dienthoai updateDt(@RequestBody DienthoaiUpdateRequest dt, @PathVariable String id) {
        return dtSer.updateDt(dt,id);
    }

    @DeleteMapping("/{id}")
    public void deleteDt(@PathVariable String id) {
        dtSer.deleteDt(id);
    }
}
