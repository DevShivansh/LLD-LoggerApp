package app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import app.constants.AppConstants;
import app.constants.LogLevel;

public class Message {

	private LogLevel level;
	
	private Class c;
	
	private String message;
	
	private String time;

	public Message(LogLevel level, Class c, String message, DateTimeFormatter formatter) {
		super();
		this.level = level;
		this.c = c;
		this.message = message;
		time = LocalDateTime.now().format(formatter);
	}
	
	public String formatAndGet() {
		return time + AppConstants.MESSAGE_ATTR_SEPARATOR + c.getName() + AppConstants.MESSAGE_ATTR_SEPARATOR
				 + level.name() + AppConstants.MESSAGE_ATTR_SEPARATOR + message;
	}

	public LogLevel getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	
	
	
}
