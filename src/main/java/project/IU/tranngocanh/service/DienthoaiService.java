package project.IU.tranngocanh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.IU.tranngocanh.dto.dienthoai.DienthoaiCreationRequest;
import project.IU.tranngocanh.dto.dienthoai.DienthoaiUpdateRequest;
import project.IU.tranngocanh.entity.Dienthoai;
import project.IU.tranngocanh.repository.DienthoaiRepository;

import java.util.List;

@Service
public class DienthoaiService {
    @Autowired
    private DienthoaiRepository dtRepo;

    public List<Dienthoai> getAll() {
        return dtRepo.findAll();
    }

    public List<Dienthoai> getDtByTen(String tenDienThoai) {
        return dtRepo.findByTenDienThoai(tenDienThoai);
    }

    public Dienthoai getDtById(String id) {
        return dtRepo.findById(id).get();
    }

    public Dienthoai createDt(DienthoaiCreationRequest dtCreate) {
        Dienthoai dt = new Dienthoai();
        dt.setTenDienThoai(dtCreate.getTenDienThoai());
        dt.setDonGia(dtCreate.getDonGia());
        dt.setHangSanXuat(dtCreate.getHangSanXuat());
        dt.setSoLuong(dtCreate.getSoLuong());
        dt.setHinhAnh(dtCreate.getHinhAnh());
        return dtRepo.save(dt);
    }

    public Dienthoai updateDt(DienthoaiUpdateRequest dtUpdate, String id) {
        Dienthoai dt = getDtById(id);
        dt.setTenDienThoai(dtUpdate.getTenDienThoai());
        dt.setHinhAnh(dtUpdate.getHinhAnh());
        dt.setHangSanXuat(dtUpdate.getHangSanXuat());
        dt.setDonGia(dtUpdate.getDonGia());
        dt.setSoLuong(dtUpdate.getSoLuong());
        return dtRepo.save(dt);
    }



    public void deleteDt(String id) {
        dtRepo.deleteById(id);
    }
}
