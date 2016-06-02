package model;

public class Brewery {
	// This class represents the brewery and keeps track of its maximum beer
	// output.

	// --variables--
	private int maxOutput;
	private int capacity;
	private int currentUsage;
	
	// Constructor
	public Brewery(int capacity_ini, int maximumOutput) {
		capacity = capacity_ini;
		this.maxOutput = maximumOutput;
		currentUsage = 0;
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
	}
	
	public void upgradeOutput(int extraOutput) {
		// TODO not implemented
	}
}
