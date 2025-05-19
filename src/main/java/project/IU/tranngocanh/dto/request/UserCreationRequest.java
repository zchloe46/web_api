package project.IU.tranngocanh.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreationRequest {
    private String userName;
    private String email;
    private String address;
    private String phone;
    private String sex;
    private String avatar;
    
}
