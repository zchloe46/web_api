package project.IU.tranngocanh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.*;

@Data
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID tự tăng trong CSDL

    @Column(unique = true, nullable = false) // Giả sử mã SV là duy nhất và không null
    private String studentId; // Mã sinh viên (từ Excel)

    private String name;
    private String email;
    private String major; // Ngành học

    // Constructors, Getters, Setters (Lombok sẽ tự tạo)
}