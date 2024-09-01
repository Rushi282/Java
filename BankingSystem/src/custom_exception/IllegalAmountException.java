package custom_exception;

@SuppressWarnings("serial")
public class IllegalAmountException extends Exception{

	public IllegalAmountException(String msg) {
		super(msg);
	}

}
