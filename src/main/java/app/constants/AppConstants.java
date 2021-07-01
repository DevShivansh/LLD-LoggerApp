package app.constants;

import java.time.format.DateTimeFormatter;

public interface AppConstants {

	DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	String MESSAGE_ATTR_SEPARATOR = " | ";
}
