package com.ice.todo.persistance.dao.service.interfaces;

import com.ice.todo.persistance.model.Task;

import java.util.List;

public interface TaskService {

  Task createTask(Task task);

  void removeById(long id);

  List<Task> getAllTasks();

  List<Task> getDoneTasks();

  List<Task> getCurrentTasks();

  Task updateTaskInfo(long id, Task task);

  void finishTask(long id);

}
