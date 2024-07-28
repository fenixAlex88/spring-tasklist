package by.fenix.lessons.tasklist.repository.impl;

import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public Optional<Task> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(long userId) {
        return List.of();
    }

    @Override
    public void assignToUserById(long tsakId, long userId) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void delete(long taskId) {

    }
}
