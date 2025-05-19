package project.IU.tranngocanh.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "sinhvien",
        schema = "identity_tranngocanh"
)
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idSinhVien;

    private String hoTen;
    private Date namSinh;
    private String diaChi;
    private String dienThoai;
    private String khoa;
    private String lop;
    private String hinhAnh;

}
