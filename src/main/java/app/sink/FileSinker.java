package app.sink;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import app.constants.SinkType;
import app.model.Message;

public class FileSinker extends Sinker{
	
	private String filePath;
	
	private File fout = null;
	
	private FileOutputStream fos = null;
	
	private BufferedWriter bw = null;
	
	public FileSinker(String filePath) throws IOException{
		super(SinkType.FILE_SINKER);
		init();
	}
	
	private void init() throws IOException{
		fout = new File(filePath);
		fos = new FileOutputStream(fout);
		bw = new BufferedWriter(new OutputStreamWriter(fos));
	}

	

	@Override
	public void write(Message m) {
		try {
			bw.write(m.formatAndGet());
			bw.newLine();	
		}catch(IOException e) {
			System.out.println("Unable to message write in file");
		}
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		bw.close();
		super.finalize();
	}
	
	

	

}
