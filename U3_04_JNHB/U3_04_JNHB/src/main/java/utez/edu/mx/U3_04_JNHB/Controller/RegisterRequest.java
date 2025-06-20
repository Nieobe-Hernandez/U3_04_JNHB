package utez.edu.mx.U3_04_JNHB.Controller;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String role; 
}
