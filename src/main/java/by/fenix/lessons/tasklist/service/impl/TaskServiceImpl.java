package by.fenix.lessons.tasklist.service.impl;

import by.fenix.lessons.tasklist.domain.exception.ResourceNotFoundException;
import by.fenix.lessons.tasklist.domain.task.Status;
import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.repository.TaskRepository;
import by.fenix.lessons.tasklist.repository.UserRepository;
import by.fenix.lessons.tasklist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getById(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(long id) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null)
            task.setStatus(Status.TODO);
        taskRepository.update(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(Task task, Long userId) {
        task.setStatus(Status.TODO);
        taskRepository.create(task);
        taskRepository.assignToUserById(task.getId(), userId);
        return task;
    }

    @Override
    @Transactional
    public void delete(long id) {
        taskRepository.delete(id);
    }
}
