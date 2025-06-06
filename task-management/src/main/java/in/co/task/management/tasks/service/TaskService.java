package in.co.task.management.tasks.service;

import java.util.List;

import in.co.task.management.tasks.dto.TaskDto;
import in.co.task.management.tasks.exceptions.DuplicateTaskException;
import in.co.task.management.tasks.exceptions.TaskNotFoundException;

public interface TaskService {
	public abstract List<TaskDto> getAllTasks();
	public abstract TaskDto getTaskById(Integer id) throws TaskNotFoundException;
	public abstract void createTask(TaskDto dto) throws DuplicateTaskException;
	public abstract TaskDto updateTask(TaskDto dto, Integer id) throws TaskNotFoundException;
	public abstract void deleteTask(Integer id) throws TaskNotFoundException;
}
