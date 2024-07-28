package by.fenix.lessons.tasklist.web.mappers;

import by.fenix.lessons.tasklist.domain.user.User;
import by.fenix.lessons.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto (User user);

    User toEntity (UserDto userDto);

}
