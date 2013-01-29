package uk.ac.aber.dcs.cs221.monstermash.data.remote;

public class Server {

	private volatile String httpAddress;
	private volatile String serverName;
	
	
	public void readJSON(Object object) {
		// TODO Auto-generated method stub
		
	}

	public synchronized String getName() {
		// TODO Auto-generated method stub
		return serverName;
	}
	
	public synchronized Server setName(String s) {
		this.serverName = s;
		return this;
	}

}
