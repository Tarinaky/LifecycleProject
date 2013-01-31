package aber.dcs.cs221.group5.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;

import aber.dcs.cs221.group5.data.TableOfAccounts;


public class GenerateTestData {
	
	public static void main(String arg[]) throws IOException, JSONException {
	
		TableOfAccounts data = new TableOfAccounts();
		
		data.addUser("hello1.gmail.com").setPassword("test1");
		data.addUser("james23@hotmail.com").setPassword("test2");
		data.addUser("ck2@aol.co.uk").setPassword("test3");
		data.addUser("byebye8@outlook.co.uk").setPassword("test4");
		data.addUser("wonkado27@live.co.uk").setPassword("test5");
		
		BufferedWriter out = new BufferedWriter(new FileWriter("monstermash_data_persistance.json"));
		out.append(data.buildJSON().toString(4) );
		out.flush();
		System.out.println("Test data written.");
	}

}
