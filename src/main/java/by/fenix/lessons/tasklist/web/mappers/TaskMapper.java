package by.fenix.lessons.tasklist.web.mappers;

import by.fenix.lessons.tasklist.domain.task.Task;
import by.fenix.lessons.tasklist.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto (Task task);

    List<TaskDto> toDto (List<Task> task);

    Task toEntity (TaskDto taskDto);

}
