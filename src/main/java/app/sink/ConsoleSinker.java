package app.sink;


import java.io.PrintWriter;

import app.constants.SinkType;
import app.model.Message;

public class ConsoleSinker extends Sinker{

	private PrintWriter writer;
	
	public ConsoleSinker() {
		super(SinkType.CONSOLE_SINKER);
		writer = new PrintWriter(System.out);
	}

	@Override
	public void write(Message m) {
		writer.print(m.formatAndGet());
		
	}

	
	

}
