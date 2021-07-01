package app.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import app.constants.ErrMessage;
import app.constants.LogLevel;
import app.constants.SinkType;
import app.sink.Sinker;

public class SinkConfig implements Configurer<SinkType, LogLevel>{

	private Map<SinkType, Sinker> sinkMap = new HashMap<>();
	
	
	public void addSinker(Sinker s) {
		sinkMap.put(s.getSinkType(), s);
	}
	
	

	@Override
	public void addConfig(SinkType key, LogLevel value) {
		
		if(!sinkMap.containsKey(key))
			throw new RuntimeException(ErrMessage.ERR_CONFIG_SINKER);
		
		sinkMap.get(key).addLogLevelSupport(value);
		
	}

	public Set<Sinker> sinkers(){
		return (Set<Sinker>) sinkMap.values();
	}


	@Override
	public ConfigType getConfigType() {
		
		return ConfigType.SINK_CONFIG;
	}
}
