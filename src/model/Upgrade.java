package model;

public class Upgrade {
	// This class represents one Upgrade

	// --variables--

	private int[] costs = {2000, 3850, 7500, 2000, 3750, 9000};
	private int[] effects = {100, 200, 400, 5, 20, 500};
	private int[] roundlyCosts = {100, 150, 220, 0, 300, 500};
	private String[] descriptions = {"Regal", "kleiner Anbau", "Lager Halle", "Säuberung", "dickere Rohre", "Kessel"};
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
