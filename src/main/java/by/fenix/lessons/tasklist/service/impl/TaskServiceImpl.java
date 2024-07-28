package by.fenix.lessons.tasklist.service.impl;

import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task getById(long id) {
        return null;
    }

    @Override
    public List<Task> getAllByUserId(long id) {
        return List.of();
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task create(Task task, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
