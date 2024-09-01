package custom_exception;

@SuppressWarnings("serial")
public class InsufficientFundException extends Exception {

	public InsufficientFundException(String msg) {
		super(msg);
	}

}
