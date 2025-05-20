package project.IU.tranngocanh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.IU.tranngocanh.dto.sinhvien.SinhVienCreateRequest;
import project.IU.tranngocanh.entity.SinhVien;
import project.IU.tranngocanh.repository.SinhVienRepository;

@Service
public class SinhvienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(String id) {
        return sinhVienRepository.findById(id).get();
    }

    public List<SinhVien> getSinhVienByLop(String lop) {
        return sinhVienRepository.findByLop(lop);
    }

    public List<SinhVien> getSinhVienByHoten(String hoten) {
        return sinhVienRepository.findByHoTen(hoten);
    }

    public SinhVien themSinhVien(SinhVienCreateRequest sinhVienCreateRequest) {
        SinhVien sv = new SinhVien();
        sv.setHoTen(sinhVienCreateRequest.getHoTen());
        sv.setNamSinh(sinhVienCreateRequest.getNamSinh());
        sv.setDiaChi(sinhVienCreateRequest.getDiaChi());
        sv.setDienThoai(sinhVienCreateRequest.getDienThoai());
        sv.setKhoa(sinhVienCreateRequest.getKhoa());
        sv.setLop(sinhVienCreateRequest.getLop());
        sv.setHinhAnh(sinhVienCreateRequest.getHinhAnh());
        return sinhVienRepository.save(sv);
    }

    public void deleteSinhVien(String id) {
        sinhVienRepository.deleteById(id);
    }

    public void updateSinhVien(String id, SinhVienCreateRequest sinhVienCreateRequest) {
        SinhVien sv = getSinhVienById(id);
        sv.setHoTen(sinhVienCreateRequest.getHoTen());
        sv.setNamSinh(sinhVienCreateRequest.getNamSinh());
        sv.setDiaChi(sinhVienCreateRequest.getDiaChi());
        sv.setDienThoai(sinhVienCreateRequest.getDienThoai());
        sv.setKhoa(sinhVienCreateRequest.getKhoa());
        sv.setLop(sinhVienCreateRequest.getLop());
        sv.setHinhAnh(sinhVienCreateRequest.getHinhAnh());
        sinhVienRepository.save(sv);
    }
}
