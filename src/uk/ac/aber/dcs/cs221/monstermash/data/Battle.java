package uk.ac.aber.dcs.cs221.monstermash.data;

public class Battle {
	private volatile Monster defender = null;
	private volatile Monster challenger = null;
	private volatile boolean valid = false;
	
	public Battle(Monster defender, Monster challenger) {
		this.defender = defender;
		this.challenger = challenger;
		
		//Fight the battle.
	}
	
	public boolean isValid() {
		return this.valid;
	}

}
