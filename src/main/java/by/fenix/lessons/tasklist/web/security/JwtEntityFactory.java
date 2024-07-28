package by.fenix.lessons.tasklist.web.security;

import by.fenix.lessons.tasklist.domain.user.Role;
import by.fenix.lessons.tasklist.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtEntityFactory {

    public static JwtEntity create (User user) {
        return new JwtEntity(
                user.getId(),
                user.getUserName(),
                user.getName(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<Role>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities (List<Role> roles) {
        return roles.stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
