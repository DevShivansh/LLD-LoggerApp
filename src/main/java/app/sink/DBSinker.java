package app.sink;

import app.constants.SinkType;
import app.model.Message;

public class DBSinker extends Sinker{
	
	private String dataSourceUrl;
	
	private String userName;
	
	private String password;
	
	public DBSinker(String dataSourceUrl, String userName, String password) {
		super(SinkType.FILE_SINKER);
		this.dataSourceUrl = dataSourceUrl;
		this.userName = userName;
		this.password = password;
		initDBConnection();
	}

	private void initDBConnection() {
		// init db connection
		
	}

	@Override
	public void write(Message m) {
		// write message with help of DB classes
		
	}

	
}
