package app.model;

import java.util.LinkedList;
import java.util.Queue;

import app.sink.Sinker;

public class LogQueue<T extends Sinker> implements Runnable{

	private T sinker;
	
	private Queue<Message> queue = new LinkedList<>();
	
	private boolean stopQueue = false;
	
	public LogQueue(T sinker) {
		this.sinker = sinker;
	}

	@Override
	public void run() {
		
		while(!stopQueue) {
			if(queue.isEmpty())
				continue;
			Message m = queue.poll();
			sinker.write(m);
		}
		
	}
	
	public void addMessage(Message m) {
		queue.add(m);
	}
	
	public void stopQueue() {
		stopQueue = false;
	}
	
	
}
