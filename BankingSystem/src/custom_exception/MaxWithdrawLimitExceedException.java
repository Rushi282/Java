package custom_exception;

@SuppressWarnings("serial")
public class MaxWithdrawLimitExceedException extends Exception{

	public MaxWithdrawLimitExceedException(String msg) {
		super(msg);
	}

}
