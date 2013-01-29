package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;

public class ServerTableTest {
	
	private ServerTable instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new ServerTable();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoad() throws UniformInterfaceException, ClientHandlerException, JSONException {
		instance.load();
	}

}
