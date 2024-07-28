package by.fenix.lessons.tasklist.web.controller;

import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.service.TaskService;
import by.fenix.lessons.tasklist.web.dto.task.TaskDto;
import by.fenix.lessons.tasklist.web.dto.validation.OnUpdate;
import by.fenix.lessons.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedtask = taskService.update(task);
        return taskMapper.toDto(updatedtask);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteBuId(@PathVariable Long id) {
        taskService.delete(id);
    }

}
