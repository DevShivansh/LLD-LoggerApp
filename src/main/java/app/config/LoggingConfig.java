package app.config;

import app.constants.LogLevel;

public class LoggingConfig implements Configurer<ConfigType, LogLevel>{

	private LogLevel defaultLogger;
	
	private ConfigType configType;
	
	
	@Override
	public void addConfig(ConfigType key, LogLevel value) {
		this.defaultLogger = value;
		this.configType = key;
		
	}

	public LogLevel defaultLogger() {
		return defaultLogger;
	}


	@Override
	public ConfigType getConfigType() {
		return configType;
	}
}
