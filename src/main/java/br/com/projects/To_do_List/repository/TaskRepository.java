package br.com.projects.To_do_List.repository;

import br.com.projects.To_do_List.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
