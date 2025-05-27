package project.IU.tranngocanh.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUser;

    private String userName;
    private String email;
    private String address;
    private String phone;
    private String sex;
    private String avatar;
}
