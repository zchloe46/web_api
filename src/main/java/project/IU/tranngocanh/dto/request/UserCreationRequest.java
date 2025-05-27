package project.IU.tranngocanh.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserCreationRequest {
    private String userName;
    private String email;
    private String address;
    private String phone;
    private String sex;
    private String avatar;
    
}
