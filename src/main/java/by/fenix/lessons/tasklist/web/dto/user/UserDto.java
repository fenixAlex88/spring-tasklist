package by.fenix.lessons.tasklist.web.dto.user;

import by.fenix.lessons.tasklist.web.dto.validation.OnCreate;
import by.fenix.lessons.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "id must be not null", groups = OnUpdate.class)
    private long id;

    @NotNull(message = "name must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "name length must by smaller then 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "userName must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "userName length must by smaller then 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password must be not null", groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password confirmation must be not null", groups = {OnUpdate.class, OnCreate.class})
    private String passwordConfirmation;

}
