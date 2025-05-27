package project.IU.tranngocanh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dienthoai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String tenDienThoai;
    private String hangSanXuat;
    private int soLuong;
    private float donGia;
    private String hinhAnh;
}
