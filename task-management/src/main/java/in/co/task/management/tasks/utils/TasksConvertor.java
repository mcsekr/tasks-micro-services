package in.co.task.management.tasks.utils;

import org.springframework.beans.BeanUtils;

import in.co.task.management.tasks.dao.entity.TaskEntity;
import in.co.task.management.tasks.dto.TaskDto;

public class TasksConvertor {
	public static TaskDto getDto(TaskEntity e) {
		TaskDto dto = new TaskDto();
		BeanUtils.copyProperties(e, dto);
		return dto;
	}

	public static TaskEntity getEntity(TaskDto d) {
		TaskEntity e = new TaskEntity();
		BeanUtils.copyProperties(d, e);
		return e;
	}
}
