package in.co.task.management.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.task.management.tasks.dto.TaskDto;
import in.co.task.management.tasks.exceptions.DuplicateTaskException;
import in.co.task.management.tasks.exceptions.TaskNotFoundException;
import in.co.task.management.tasks.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/api/v1/tasks")
	public ResponseEntity<Object> saveEmployee(@RequestBody TaskDto dto) throws DuplicateTaskException {
		taskService.createTask(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping("/api/v1/tasks")
	public ResponseEntity<Object> getAllEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
	}

	@GetMapping("/api/v1/tasks/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id) throws TaskNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(id));
	}

	@PutMapping("/api/v1/tasks/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Integer id, @RequestBody TaskDto dto)
			throws TaskNotFoundException {
		TaskDto updatedDto = taskService.updateTask(dto, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
	}

	@DeleteMapping("/api/v1/tasks/{id}")
	public ResponseEntity<Object> delteEmployee(@PathVariable Integer id) throws TaskNotFoundException {
		taskService.deleteTask(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
