package project.IU.tranngocanh.entity;

import jakarta.persistence.*;
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
        name = "user",
        schema = "identity_tranngocanh"
)
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
