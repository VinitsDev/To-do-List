package br.com.projects.To_do_List.service;

import br.com.projects.To_do_List.dtos.TaskRequest;
import br.com.projects.To_do_List.dtos.TaskResponse;
import br.com.projects.To_do_List.entities.Task;
import br.com.projects.To_do_List.mappers.TaskMapper;
import br.com.projects.To_do_List.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponse create(TaskRequest request){
        Task task = taskMapper.toTask(request);
        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public TaskResponse update(Task task){
        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public List<TaskResponse> listAll(){
        List<Task> tasks = taskRepository.findAll(Sort.by("deadline").ascending());
        return tasks.stream().map(taskMapper::toResponse).toList();
    }

    public TaskResponse find(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));
        return taskMapper.toResponse(task);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }


}
