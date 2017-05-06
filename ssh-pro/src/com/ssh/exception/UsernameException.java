package com.ssh.exception;

public class UsernameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameException() {
		super();
	}

	public UsernameException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UsernameException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UsernameException(String arg0) {
		super(arg0);
	}

	public UsernameException(Throwable arg0) {
		super(arg0);
	}
	

}
