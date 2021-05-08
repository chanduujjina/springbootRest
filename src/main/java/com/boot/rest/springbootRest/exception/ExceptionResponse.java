package com.boot.rest.springbootRest.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	private String message;
    private LocalDateTime dateTime;

}
