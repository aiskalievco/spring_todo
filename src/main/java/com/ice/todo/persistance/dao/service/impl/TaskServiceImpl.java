package com.ice.todo.persistance.dao.service.impl;

import com.ice.todo.persistance.dao.repository.TaskRepository;
import com.ice.todo.persistance.dao.service.interfaces.TaskService;
import com.ice.todo.persistance.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: repository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public List<Task> getDoneTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: repository.findByIsDone(true)) {
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public List<Task> getCurrentTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Task task: repository.findByIsDone(false)) {
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task updateTaskInfo(long id, Task task) {
        Task existTask = repository.findById(id);
        existTask.setName(task.getName());
        existTask.setDate(task.getDate());
        existTask.setDescription(task.getDescription());
        existTask.setPriority(task.getPriority());
        return repository.save(existTask);
    }

    @Override
    public void finishTask(long id) {
        Task task = repository.findById(id);
        task.setDone(true);
        repository.save(task);
    }

    @Autowired
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }
}
