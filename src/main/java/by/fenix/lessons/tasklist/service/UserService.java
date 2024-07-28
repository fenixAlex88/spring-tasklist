package by.fenix.lessons.tasklist.service;

import by.fenix.lessons.tasklist.domain.user.User;

public interface UserService {

    User getById (Long id);

    User getByUserName (String userName);

    User update (User user);

    User create (User user);

    boolean isTaskOwner (long userId, long taskId);

    void delete (long id);
}
