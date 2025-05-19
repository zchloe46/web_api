package project.IU.tranngocanh.dto.sinhvien;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SinhVienCreateRequest {
    private String hoTen;
    private Date namSinh;
    private String diaChi;
    private String dienThoai;
    private String khoa;
    private String lop;
    private String hinhAnh;
}
