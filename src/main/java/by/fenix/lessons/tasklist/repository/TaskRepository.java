package by.fenix.lessons.tasklist.repository;

import by.fenix.lessons.tasklist.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(long id);

    List<Task> findAllByUserId (long userId);

    void assignToUserById(long tsakId, long userId);

    void update (Task task);

    void create (Task task);

    void delete (long taskId);

}
