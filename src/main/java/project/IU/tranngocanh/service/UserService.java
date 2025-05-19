package project.IU.tranngocanh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.IU.tranngocanh.dto.request.UserCreationRequest;
import project.IU.tranngocanh.dto.request.UserUpdateRequest;
import project.IU.tranngocanh.entity.User;
import project.IU.tranngocanh.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

//    public User creatUsr(User user) {
//        User newUser = new User();
//        newUser.setUserName(user.getUserName());
//        newUser.setEmail(user.getEmail());
//        newUser.setAddress(user.getAddress());
//        newUser.setPhone(user.getPhone());
//        newUser.setSex(user.getSex());
//        newUser.setAvatar(user.getAvatar());
//        return userRepository.save(newUser);
//    }

    public void deleteUser(String idUser) {
        userRepository.deleteById(idUser);
    }
    // Create a new user from UserCreationRequest
    public User createRequest(UserCreationRequest userCreationRequest) {
        User user = new User();
        user.setUserName(userCreationRequest.getUserName());
        user.setEmail(userCreationRequest.getEmail());
        user.setAddress(userCreationRequest.getAddress());
        user.setPhone(userCreationRequest.getPhone());
        user.setSex(userCreationRequest.getSex());
        user.setAvatar(userCreationRequest.getAvatar());
        return userRepository.save(user);
    }

    public User updateUser(String idUser, UserUpdateRequest userUpdateRequest) {
        // lay user ra bang id
        User user = getUserById(idUser);

        // update user
        user.setUserName(userUpdateRequest.getUserName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setAddress(userUpdateRequest.getAddress());
        user.setPhone(userUpdateRequest.getPhone());
        user.setSex(userUpdateRequest.getSex());
        user.setAvatar(userUpdateRequest.getAvatar());
        return userRepository.save(user);
    }

    public User getUserById(String idUser) {
        return userRepository.findById(idUser).get();
    }

    public List<User> getUserByAddr(String addr) {
        return userRepository.findByAddress(addr);
    }

    
}
