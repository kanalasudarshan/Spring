package com.ksr.service.exception;

public class ApplicationException extends Exception {
	
	public ApplicationException(String exString){
		super(exString);
	}
	public ApplicationException(Throwable exception){
		super(exception);
	}
}
