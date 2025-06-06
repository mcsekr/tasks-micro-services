package in.co.task.management.tasks.exceptions;

public class DuplicateTaskException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public DuplicateTaskException() {
		super();
	}

	public DuplicateTaskException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
