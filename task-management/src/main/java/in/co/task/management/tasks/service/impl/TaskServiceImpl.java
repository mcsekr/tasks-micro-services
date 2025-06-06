package in.co.task.management.tasks.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.task.management.tasks.dao.entity.TaskEntity;
import in.co.task.management.tasks.dao.repo.TaskRepository;
import in.co.task.management.tasks.dto.TaskDto;
import in.co.task.management.tasks.exceptions.DuplicateTaskException;
import in.co.task.management.tasks.exceptions.TaskNotFoundException;
import in.co.task.management.tasks.service.TaskService;
import in.co.task.management.tasks.utils.TasksConvertor;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;

	@Override
	public List<TaskDto> getAllTasks() {
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		repository.findAll().stream().forEach(t -> dtos.add(TasksConvertor.getDto(t)));
		return dtos;
	}

	@Override
	public TaskDto getTaskById(Integer id) throws TaskNotFoundException {
		Optional<TaskEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return TasksConvertor.getDto(entity.get());
		}
		throw new TaskNotFoundException("No task found with id " + id);
	}

	@Override
	public void createTask(TaskDto dto) throws DuplicateTaskException {
		Optional<TaskEntity> entity = repository.findById(dto.getId());
		if (entity.isPresent()) {
			throw new DuplicateTaskException("Already task present with id " + dto.getId());
		}
		repository.save(TasksConvertor.getEntity(dto));
	}

	@Override
	public TaskDto updateTask(TaskDto dto, Integer id) throws TaskNotFoundException {
		Optional<TaskEntity> entity = repository.findById(id);
		if (!entity.isPresent()) {
			throw new TaskNotFoundException("No task present with id " + id);
		}
		return TasksConvertor.getDto(repository.save(TasksConvertor.getEntity(dto)));
	}

	@Override
	public void deleteTask(Integer id) throws TaskNotFoundException {
		Optional<TaskEntity> entity = repository.findById(id);
		if (!entity.isPresent()) {
			throw new TaskNotFoundException("No task present with id " + id);
		}
		repository.delete(entity.get());
	}

}
