package aber.dcs.cs221.group5.data.remote;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import aber.dcs.cs221.group5.data.Monster;

public class RemoteMonster extends Monster {
	
	public RemoteMonster() {}
	
	public synchronized RemoteMonster readJSON(JSONObject json, RemoteUser owner) throws JSONException {
		
		this.setName(json.getString("monsterID"));
		this.setOwner(owner);
		
		this.strengthCoefficient = (int)(100*json.getDouble("baseStrength") );
		this.evadeCoefficient = (int)(100*json.getDouble("baseDefence") );
		this.toughnessCoefficient = (int)(100*json.getDouble("baseHealth") );
		
		this.dateOfBirth = new Date(json.getLong("birthDate") );
		
		this.isForTupping(json.getInt("breedOffer") != 0);
		this.setTuppingPrice(json.getInt("breedOffer") );
		
		this.isForSale(json.getInt("saleOffer") != 0);
		this.setSalePrice(json.getInt("saleOffer") );
		
		return this;
	}

}
