package model;

public class Upgrade {
	// This class represents one Upgrade

	// --variables--

	private int[] costs;
	private int[] effects;
	private int[] roundlyCosts;
	private String[] descriptions;
	private int id;
	private Bank bank;

	public Upgrade(int ini_id, Bank bank_ini) {
		id = ini_id;
		bank = bank_ini;
	}

	public int getCosts() {
		return costs[id];
	}

	public int getEffects() {
		return effects[id];
	}

	public int getRoundlyCosts() {
		return roundlyCosts[id];
	}

	public String getDescriptions() {
		return descriptions[id];
	}
	
	public boolean isPossible() {
		return bank.getCapital() >= costs[id];
	}

}
