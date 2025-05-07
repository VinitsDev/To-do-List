package br.com.projects.To_do_List.service;

import br.com.projects.To_do_List.entities.Task;
import br.com.projects.To_do_List.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;


    public List<Task> create(Task task){
        taskRepository.save(task);
        return listALL();
    }

    public List<Task> update(Task task){
        taskRepository.save(task);
        return listALL();
    }

    public List<Task> listALL(){
        return taskRepository.findAll(Sort.by("priority").descending().and(Sort.by("name").ascending()));
    }

    public List<Task> delete(Long id){
        taskRepository.deleteById(id);
        return listALL();
    }


}
