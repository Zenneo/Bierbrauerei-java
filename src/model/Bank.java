package model;

public class Bank {
	// This class keeps track of the currently available capital. It also
	// handles money transfers

	// --variables--
	private int capital;
	
	public Bank(int initalCapital) {
		capital = initalCapital;
	}
	
	public int getCapital() {
		return capital;
	}

	public void payIn(int amount) {
		// TODO not implemented
		// TODO throws exception when failed
	}
	
	public void payOut(int amount) {
		// TODO not implemented
		// TODO throws exception when failed
	}
}
