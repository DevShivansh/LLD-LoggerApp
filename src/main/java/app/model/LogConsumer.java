package app.model;

import java.util.HashMap;
import java.util.Map;

import app.constants.LogLevel;
import app.sink.ConsoleSinker;
import app.sink.Sinker;

public class LogConsumer {
	
	private LogLevel defaultLogLevel;
	
	private Map<LogLevel, LogQueue<Sinker>> queueMap = new HashMap<>();
	
	public LogConsumer(LogLevel defaultLogLevel) {
		super();
		this.defaultLogLevel = defaultLogLevel;
		initDefaultSinker();
	}

	private void initDefaultSinker() {
		ConsoleSinker console = new ConsoleSinker();
		for(LogLevel l : LogLevel.values()) {
			if(!defaultLogLevel.isEquivalentOrAbove(l))
				continue;
			configureSinker(l, console);
		}
		
	}

	public void log(Message m) {
		
		if(!defaultLogLevel.isEquivalentOrAbove(m.getLevel()))
			return;
		
		if(!queueMap.containsKey(m.getLevel()))
			throw new RuntimeException("Queue not configured in QueueManager for LogLevel : " + m.getLevel());
			
		queueMap.get(m.getLevel()).addMessage(m);
		
	}
	
	public void configureSinker(LogLevel l, Sinker sinker) {
		queueMap.put(l, new LogQueue<Sinker>(sinker));
	}

}
