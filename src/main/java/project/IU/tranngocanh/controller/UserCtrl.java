package project.IU.tranngocanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.IU.tranngocanh.dto.request.UserCreationRequest;
import project.IU.tranngocanh.dto.request.UserUpdateRequest;
import project.IU.tranngocanh.entity.User;
import project.IU.tranngocanh.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserCtrl {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/address/{addr}")
    public List<User> getUserByAddr(@PathVariable String addr) {
        return userService.getUserByAddr(addr);
    }

    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable String idUser) {
        return userService.getUserById(idUser);
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationRequest user) {
        return userService.createRequest(user);
    }

    @DeleteMapping("/{idUser}")
    public String deleteUser(@PathVariable String idUser) {
        userService.deleteUser(idUser);
        return "Delete user successfully";
        
    }

    @PutMapping("/{idUser}")
    public String updateUser(@PathVariable String idUser, @RequestBody UserUpdateRequest userUpdate) {
        userService.updateUser(idUser, userUpdate);
        return "Update user successfully";
    }

    
}
