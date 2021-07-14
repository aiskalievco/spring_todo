package com.ice.todo.persistance.dao.repository;

import com.ice.todo.persistance.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findById(long id);
    List<Task> findByIsDone(boolean isDone);
}
