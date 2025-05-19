package project.IU.tranngocanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import project.IU.tranngocanh.entity.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
    List<SinhVien> findByLop(String lop);
    List<SinhVien> findByHoTen(String hoten);
}

