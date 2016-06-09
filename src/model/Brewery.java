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
	public Brewery(int capacity_ini, int output) {
		storageMaxSpace = capacity_ini;
		this.output = output;
		storage = 0;
	}

	public void produce() {
		// TODO not implemented
	}

	public int removeBeer(int amount) {
		// TODO not implemented
		// TODO replace me
		return 0;
	}

	public void upgradeStorage(int extraCapacity) {
		// TODO not implemented
		// TODO throws exception when failed
	}

	public void upgradeOutput(int extraOutput) {
		// TODO not implemented
		// TODO throws exception when failed
	}

	public void upgradeRoundlyCosts(int extraRoundlyCosts) {
		// TODO not implemented
		// TODO throws exception when failed
	}
}
