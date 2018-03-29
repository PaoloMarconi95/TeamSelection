package first ;

public class RetryException extends Exception {
	
	private static final long serialVersionUID = 1L;


	public RetryException(String errorMessage) {
		super(errorMessage) ;
	}

}