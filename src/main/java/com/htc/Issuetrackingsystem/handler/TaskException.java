package com.htc.Issuetrackingsystem.handler;

import org.springframework.http.HttpStatus;

public class TaskException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpstatus;

	public TaskException(String message, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.httpstatus = httpstatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}

}
