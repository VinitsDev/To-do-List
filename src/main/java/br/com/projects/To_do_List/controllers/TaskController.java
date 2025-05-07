package br.com.projects.To_do_List.controllers;


import br.com.projects.To_do_List.entities.Task;
import br.com.projects.To_do_List.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public List<Task> create(@RequestBody Task task){
        return taskService.create(task);
    }

    @PutMapping
    public List<Task> update(@RequestBody Task task){
        return taskService.update(task);
    }

    @GetMapping
    public List<Task> listALL(){
        return taskService.listALL();
    }

    @DeleteMapping("{id}")
    public List<Task> delete(@PathVariable("id") Long id){
        return taskService.delete(id);
    }
}
