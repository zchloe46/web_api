package project.IU.tranngocanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.IU.tranngocanh.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByAddress(String address);
}


