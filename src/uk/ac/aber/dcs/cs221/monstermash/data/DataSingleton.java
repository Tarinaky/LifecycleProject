package uk.ac.aber.dcs.cs221.monstermash.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;

import org.json.JSONException;

public class DataSingleton {
	
	static volatile TableOfAccounts instance = null;
	final static String dataPath = "monstermash_data_persistance.json";
	final static int serialisationPeriod = 60000;//One minute in miliseconds.
	
	public static synchronized TableOfAccounts get() {
		if (instance == null) {
			instance = new TableOfAccounts();//Initialise
			
			//Try to load from file.
			try {
				BufferedReader in = new BufferedReader(new FileReader(dataPath));
				
				StringBuilder sb = new StringBuilder();
				while (in.ready()) {
					String line = in.readLine();
					sb.append(line);
				}
				
				instance.readJSON(sb.toString());
				
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Could not open file "+dataPath+" for reading");
			} catch (JSONException e) {
				e.printStackTrace();
				System.err.println("Could not parse file "+dataPath+".");
			}
			
			//Serialise on exit.
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					DataSingleton.save();
				}
			}));
			
			//Serialise periodically.
			java.util.Timer timer = new java.util.Timer();
			TimerTask periodicSerialisation = new TimerTask() {
				public void run() {
					DataSingleton.save();
				}
			};
			timer.schedule(periodicSerialisation, serialisationPeriod);
			
			
		}
		return instance;
	}
	
	public static synchronized void save() {
		TableOfAccounts t = get();
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(dataPath));
			out.append(t.buildJSON().toString());
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.err.println("Failed to open file "+dataPath+" for writing.");
		} catch (JSONException e) {
			e.printStackTrace();
			System.err.println("Failed to build JSON expression for data.");
		}
	}

}
