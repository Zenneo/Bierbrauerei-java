package model;

public class Brewery {
	// This class represents the brewery and keeps track of its maximum beer
	// output.

	// --variables--
	private Bank bank;

	private int storageMaxSpace; // maximum amount stored
	private int storage; // current amount stored
	private int output; // output per round
	private int roundlyCosts; // cost per round

	// getters
	public int getStorageMaxSpace() {
		return storageMaxSpace;
	}

	public int getStorage() {
		return storage;
	}

	public int getOutput() {
		return output;
	}

	public int getRoundlyCosts() {
		return roundlyCosts;
	}

	// Constructor
	public Brewery(int capacity_ini, int output_init) {
		storageMaxSpace = capacity_ini;
		this.output = output_init;
		storage = 0;
	}

	public void produce() {
		storage = storage + output;
		if (storage > storageMaxSpace)
		{
			storage = storageMaxSpace;
		}
	}

	public void removeBeer(int amount) {
		if (storage < amount)
		{
			throw new UnsupportedOperationException("zu wenig Bier im Lager");
		} else {
			storage = storage - amount;
		}
	}

	public void upgradeStorage(int extraCapacity) {
		storageMaxSpace = storageMaxSpace + extraCapacity;
	}

	public void upgradeOutput(int extraOutput) {
		output = output + extraOutput;
	}

	public void upgradeRoundlyCosts(int extraRoundlyCosts) {
		roundlyCosts = roundlyCosts + extraRoundlyCosts;
	}
}
