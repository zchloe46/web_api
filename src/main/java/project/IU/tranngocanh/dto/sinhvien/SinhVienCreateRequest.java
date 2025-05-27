package project.IU.tranngocanh.dto.sinhvien;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SinhVienCreateRequest {
    private String hoTen;
    private Date namSinh;
    private String diaChi;
    private String dienThoai;
    private String khoa;
    private String lop;
    private String hinhAnh;
}
