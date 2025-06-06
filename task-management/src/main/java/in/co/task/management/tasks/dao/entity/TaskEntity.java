package in.co.task.management.tasks.dao.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TASKS")
public class TaskEntity {
	@Id
	@Column(name = "TASK_ID")
	private int id;
	@Column(name = "TASK_TITLE")
	private String title;
	@Column(name = "TASK_DESCRIPTION")
	private String description;
	@Column(name = "TASK_DUE_DATE")
	private LocalDate dueDate;
	@Column(name = "TASK_PRIORITY")
	private String priority;
	@Column(name = "TASK_COMPLETE_STATIUS")
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
		TaskEntity other = (TaskEntity) obj;
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
