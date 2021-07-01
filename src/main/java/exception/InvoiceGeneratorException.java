package exception;

public class InvoiceGeneratorException extends Exception {

	private static final long serialVersionUID = 1L;

	public enum ExceptionType {
		USER_ALREADY_EXISTS
	}

	public ExceptionType type;

	public InvoiceGeneratorException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}
