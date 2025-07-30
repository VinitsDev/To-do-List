package br.com.projects.To_do_List.controllers;


import br.com.projects.To_do_List.dtos.TaskRequest;
import br.com.projects.To_do_List.dtos.TaskResponse;
import br.com.projects.To_do_List.entities.Task;
import br.com.projects.To_do_List.mappers.TaskMapper;
import br.com.projects.To_do_List.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(description = "Creates a new task")
    public ResponseEntity<TaskResponse> create(@RequestBody @Valid TaskRequest request){
        TaskResponse response = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    @Operation(description = "Updates a task")
    public ResponseEntity<TaskResponse> update(@RequestBody @Valid Task task){
        TaskResponse response = taskService.update(task);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(description = "Returns a list with all tasks")
    public List<TaskResponse> listAll(){
        return taskService.listAll();
    }

    @GetMapping("{id}")
    @Operation(description = "Search for a specific task")
    public ResponseEntity<TaskResponse> find(@PathVariable("id") Long id) {
        TaskResponse response = taskService.find(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Deletes a task")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
