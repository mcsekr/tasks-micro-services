package in.co.task.management.tasks.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	private int id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private String priority;
	private boolean isCompleted;

	@Override
	public int hashCode() {
		return Objects.hash(description, dueDate, id, isCompleted, priority, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDto other = (TaskDto) obj;
		return Objects.equals(description, other.description) && Objects.equals(dueDate, other.dueDate)
				&& id == other.id && isCompleted == other.isCompleted && Objects.equals(priority, other.priority)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", priority=" + priority + ", isCompleted=" + isCompleted + "]";
	}

}
