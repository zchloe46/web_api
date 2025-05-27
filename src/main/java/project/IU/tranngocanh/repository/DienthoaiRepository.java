package project.IU.tranngocanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.IU.tranngocanh.entity.Dienthoai;

import java.util.List;

public interface DienthoaiRepository extends JpaRepository<Dienthoai, String> {
    @Query("SELECT d FROM Dienthoai d WHERE LOWER(d.tenDienThoai) LIKE LOWER(CONCAT('%', :tenDienThoai, '%'))")
    List<Dienthoai> findByTenDienThoai(@Param("tenDienThoai") String tenDienThoai);
}
