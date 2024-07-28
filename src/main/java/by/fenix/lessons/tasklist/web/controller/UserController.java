package by.fenix.lessons.tasklist.web.controller;


import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.domain.user.User;
import by.fenix.lessons.tasklist.service.TaskService;
import by.fenix.lessons.tasklist.service.UserService;
import by.fenix.lessons.tasklist.web.dto.task.TaskDto;
import by.fenix.lessons.tasklist.web.dto.user.UserDto;
import by.fenix.lessons.tasklist.web.dto.validation.OnCreate;
import by.fenix.lessons.tasklist.web.dto.validation.OnUpdate;
import by.fenix.lessons.tasklist.web.mappers.TaskMapper;
import by.fenix.lessons.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update (@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById (@PathVariable long id) {
       User user = userService.getById(id);
       return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask (@PathVariable long id, @Validated(OnCreate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

}
