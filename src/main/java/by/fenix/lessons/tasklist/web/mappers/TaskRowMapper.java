package by.fenix.lessons.tasklist.web.mappers;

import by.fenix.lessons.tasklist.domain.task.Status;
import by.fenix.lessons.tasklist.domain.task.Task;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskRowMapper {

    @SneakyThrows
    public static Task mapRow(ResultSet rs) {
        if (rs.next()) {
            Task task = new Task();
            task.setId(rs.getLong("task_id"));
            task.setTitle(rs.getString("task_title"));
            task.setDescription(rs.getString("task_description"));
            task.setStatus(Status.valueOf(rs.getString("task_status")));
            Timestamp ts = rs.getTimestamp("task_expiration_date");
            if (ts != null) {
                task.setExpirationDate(ts.toLocalDateTime());
            }
            return task;
        }
        return null;
    }

    @SneakyThrows
    public static List<Task> mapRows(ResultSet rs) {
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            Task task = new Task();
            task.setId(rs.getLong("task_id"));
            if (!rs.wasNull()) {
                task.setTitle(rs.getString("task_title"));
                task.setDescription(rs.getString("task_description"));
                task.setStatus(Status.valueOf(rs.getString("task_status")));
                Timestamp ts = rs.getTimestamp("task_expiration_date");
                if (ts != null) {
                    task.setExpirationDate(ts.toLocalDateTime());
                }
                tasks.add(task);
            }
        }
        return tasks;
    }
}
