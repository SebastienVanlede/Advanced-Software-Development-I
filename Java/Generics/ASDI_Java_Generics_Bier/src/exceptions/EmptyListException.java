package exceptions;

public class EmptyListException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyListException() {
        this("List");
    }

    public EmptyListException(String name) {
        super(name + " is empty");
    }
}

