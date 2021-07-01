package app.model;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import app.config.Configuration;
import app.config.DateTimeConfig;
import app.config.LoggingConfig;
import app.config.SinkConfig;
import app.constants.AppConstants;
import app.constants.LogLevel;
import app.sink.Sinker;

public class LoggerApp {
	
	private static LoggerApp app = null;
	
	private LogLevel defaultLevel = LogLevel.INFO;
	
	private DateTimeFormatter formatter = AppConstants.DEFAULT_TIME_FORMATTER;
	
	private Set<Sinker> sinkers = new HashSet<Sinker>();
	
	private LogConsumer logConsumer;

	
	public LoggerApp(Configuration configuration) {
		app = this;
		init(configuration);
	}
	
	private void init(Configuration configuration) {
		
		processConfigurations(configuration);
		initLogConsumer();
		
	}

	private void initLogConsumer() {
		logConsumer = new LogConsumer(defaultLevel);
		sinkers.forEach( s -> {
			s.getLevelsToSink().forEach( level -> {
				logConsumer.configureSinker(level, s);
			});
		});
		
	}

	private void processConfigurations(Configuration configuration) {
		configuration.forEach( config -> {
			switch(config.getConfigType()) {
			case TIME_FORMAT:
				formatter = ((DateTimeConfig) config).dateTime();
				break;
			case LOGGING_LEVEL:
				defaultLevel = ((LoggingConfig) config).defaultLogger();
				break;
			case SINK_CONFIG:
				sinkers.addAll(((SinkConfig) config).sinkers());
				break;
			}
		});
	}

	
	public static LoggerApp getInstance() {
		return app;
	}
	
	
	public Logger newlogger(Class c) {
		
		if(logConsumer == null)
			throw new RuntimeException("LogConsumer not initialised, please set Configurations");
		
		return new Logger(logConsumer, c, formatter);
		
	}
}
