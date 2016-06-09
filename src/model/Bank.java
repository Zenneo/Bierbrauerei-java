package model;

public class Bank {
	// This class keeps track of the currently available capital. It also
	// handles money transfers

	private int capital;

	public Bank(int initalCapital) {
		capital = initalCapital;
	}

	public int getCapital() {
		return capital;
	}

	public void payIn(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(
					"Es kann kein negativer Betrag eingezahlt werden");
		} else {
			capital += amount;
		}
	}

	public void payOut(int amount) {
		if (capital < amount) {
			throw new IllegalArgumentException("zu wenig Geld auf der Bank");
		} else {
			capital -= amount;
		}
	}
}
