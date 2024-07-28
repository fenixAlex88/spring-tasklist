package by.fenix.lessons.tasklist.domain.user;

import by.fenix.lessons.tasklist.domain.task.Task;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {

    private long id;
    private String name;
    private String userName;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Task> tasks;

}
