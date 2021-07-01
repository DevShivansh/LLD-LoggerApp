package app.sink;

import java.util.HashSet;
import java.util.Set;

import app.constants.LogLevel;
import app.constants.SinkType;
import app.model.Message;

public abstract class Sinker {

	private Set<LogLevel> levelsToSink = new HashSet<LogLevel>();
	
	protected SinkType sinkType = null;
	
	protected String defaultTimeFormat = null;
	

	public Sinker(SinkType sinkType) {
		super();
		this.levelsToSink = new HashSet<LogLevel>();
		this.sinkType = sinkType;
	}

	public abstract void write(Message m);
	
	
	public Set<LogLevel> getLevelsToSink() {
		return levelsToSink;
	}
	
	public SinkType getSinkType() {
		return sinkType;
	}

	public void setDateTimeFormat(String defaultTimeFormat) {
		this.defaultTimeFormat = defaultTimeFormat;
		
	}
	
	public void addLogLevelSupport(LogLevel l) {
		levelsToSink.add(l);
		
	}
}
