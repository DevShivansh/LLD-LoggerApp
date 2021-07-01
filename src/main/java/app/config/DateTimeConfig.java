package app.config;

import java.time.format.DateTimeFormatter;


public class DateTimeConfig implements Configurer<ConfigType, DateTimeFormatter>{

	private DateTimeFormatter defaultDateTime;
	
	private ConfigType configType;
	
	
	@Override
	public void addConfig(ConfigType key, DateTimeFormatter value) {
		this.defaultDateTime = value;
		this.configType = key;
		
	}

	public DateTimeFormatter dateTime() {
		return defaultDateTime;
	}


	@Override
	public ConfigType getConfigType() {
		return configType;
	}
}
