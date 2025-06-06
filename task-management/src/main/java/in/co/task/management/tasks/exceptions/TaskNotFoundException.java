package in.co.task.management.tasks.exceptions;

public class TaskNotFoundException extends Exception {
	private static final long serialVersionUID = -4400731285174081918L;
	private String message;

	public TaskNotFoundException() {
		super();
	}

	public TaskNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
