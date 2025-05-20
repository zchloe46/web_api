package project.IU.tranngocanh.dto.sinhvien;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SinhVienUpdateRequest {
    private String hoTen;
    private Date namSinh;
    private String diaChi;
    private String dienThoai;
    private String khoa;
    private String lop;
    private String hinhAnh;
}
