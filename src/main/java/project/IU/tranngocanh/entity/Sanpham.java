package project.IU.tranngocanh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "sanpham",
        schema = "identity_tranngocanh"
)
public class Sanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String tenSanPham;
    private String hangSanXuat;
    private String namSanXuat;
    private float gia;
    private String hinhAnh;


}
