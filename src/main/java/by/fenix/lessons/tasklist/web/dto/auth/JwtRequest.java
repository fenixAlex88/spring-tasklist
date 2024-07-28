package by.fenix.lessons.tasklist.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {

    @NotNull(message = "userName must be not null")
    private String userName;

    @NotNull(message = "password must be not null")
    private String password;

}
