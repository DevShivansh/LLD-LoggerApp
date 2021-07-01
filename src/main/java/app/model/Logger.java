package app.model;

import java.time.format.DateTimeFormatter;

import app.constants.LogLevel;

public class Logger {

	private Class loggerForClass;
	
	private LogConsumer logConsumer;
	
	private DateTimeFormatter formatter;
	
	public Logger(LogConsumer logConsumer, Class c, DateTimeFormatter formatter) {
		this.loggerForClass = c;
		this.logConsumer = logConsumer;
		this.formatter = formatter;
	}
	
	public void log(LogLevel l, String message) {
		logConsumer.log(new Message(l, loggerForClass, message, formatter));
	}
	

}
