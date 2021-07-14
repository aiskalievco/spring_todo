package com.ice.todo.controllers;

import com.ice.todo.persistance.dao.service.interfaces.TaskService;
import com.ice.todo.persistance.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RestTaskController {

    private TaskService taskService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable long id) {
        taskService.removeById(id);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/done")
    public List<Task> getDoneTasks() {
        return taskService.getDoneTasks();
    }

    @GetMapping("/tasks/current")
    public List<Task> getCurrentTasks() {
        return taskService.getCurrentTasks();
    }

    @PutMapping("/edit/{id}")
    public Task updateTaskInfoById(@PathVariable long id, @RequestBody Task task) {
        return taskService.updateTaskInfo(id, task);
    }

    @PutMapping("/finish/{id}")
    public void finishTaskById(@PathVariable long id) {
        taskService.finishTask(id);
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
