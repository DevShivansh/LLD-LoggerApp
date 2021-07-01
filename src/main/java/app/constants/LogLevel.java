package app.constants;

public enum LogLevel {
	
	FATAL(1), ERROR(2), WARN(3), INFO(4), DEBUG(5);
	
	private LogLevel(int priority) {
		this.priority = priority;
	}
	
	private int priority;
	
	public int getPriority() {
		return priority;
	}

	public boolean isEquivalentOrAbove(LogLevel level) {
		
		return level.priority <= this.priority;
	}

}
