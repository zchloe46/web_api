package project.IU.tranngocanh.dto.dienthoai;

import lombok.Data;

@Data
public class DienthoaiUpdateRequest {
    private String tenDienThoai;
    private String hangSanXuat;
    private int soLuong;
    private float donGia;
    private String hinhAnh;
}
