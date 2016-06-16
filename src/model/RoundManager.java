package model;

public class RoundManager {

	// --variables--

	private int round = 0;
    private Bank bank;
    private Brewery brewery;
    private Upgrademanager upgrademanager;
    private Event event;
	public int getRound() {
		return round;
	}

	public RoundManager() {
		bank = new Bank(10000);
		brewery = new Brewery(400, 50);
		upgrademanager = new Upgrademanager(bank, brewery);
		event = new Event();
	}
	
	// does every operation and finishes a round if everything is valid 
	public void nextRound() {
		// TODO not done yet
		
		// Produce beer
		
		
		// increment round counter
		round++;
	}
	public void purchaseUpgrade(int typ, int tier) {
		//typ = 0 => storaqge
		//typ = 1 => output
		if (typ == 0)
		{
			upgrademanager.buyUpgradeStorage(tier);
		} else if (typ == 1) {
			upgrademanager.buyUpgradeOutput(tier);
		}
	}
}
