package project.IU.tranngocanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.IU.tranngocanh.entity.Sanpham;

import java.util.List;

public interface SanphamRepository extends JpaRepository<Sanpham, String> {
}
