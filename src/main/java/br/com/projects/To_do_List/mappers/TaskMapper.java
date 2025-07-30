package br.com.projects.To_do_List.mappers;

import br.com.projects.To_do_List.dtos.TaskRequest;
import br.com.projects.To_do_List.dtos.TaskResponse;
import br.com.projects.To_do_List.entities.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskMapper {

    public Task toTask(TaskRequest request){
        Task task = new Task();

        task.setName(request.name());
        task.setDescription(request.description());
        task.setStatus(true);
        task.setDeadline(request.deadline());
        task.setCreatedAt(LocalDate.now());

        return task;
    }

    public TaskRequest toRequest(Task task){
        return new TaskRequest(
                task.getName(),
                task.getDescription(),
                task.getDeadline());
    }

    public TaskResponse toResponse(Task task){
        return new TaskResponse(
                task.getName(),
                task.getDescription(),
                task.getDeadline(),
                task.getCreatedAt());
    }

}
