package by.fenix.lessons.tasklist.service;

import by.fenix.lessons.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {
    Task getById (long id);

    List<Task> getAllByUserId (long id);

    Task update (Task task);

    Task create (Task task, Long id);

    void delete (long id);
}
