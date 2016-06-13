package model;

public class Upgrademanager {
	// This class manages the upgrades
	
	// --variables--
	
	private Bank bank;
	private Brewery brewery;
	private Upgrade[] upgradesStorage;
	private Upgrade[] upgradesOutput;
	
	public Upgrademanager(Bank bank_ini, Brewery brewery_ini) {
		setUpgrades();
		bank = bank_ini;
		brewery = brewery_ini;
	}

	private void setUpgrades() {
		for (int i = 0; i < 3; i++) {
			upgradesStorage[i] = new Upgrade(i);
		}
		for (int i = 0; i < 3; i++) {
			upgradesOutput[i+3] = new Upgrade(i+3);
		}
	}
	
	public Upgrade[] getUpgradesStorage() {
		return upgradesStorage;
	}
	public Upgrade[] getUpgradesOutput() {
		return upgradesOutput;
	}
	
	public Upgrade getUpgradeOutputById(int id) {
		return upgradesOutput[id];
	}
	
	public Upgrade getUpgradeStorageById(int id) {
		return upgradesStorage[id];
	}
	
	public void buyUpgradeStorage(int id) {
		bank.payOut(getUpgradeStorageById(id).getCosts());
		brewery.upgradeStorage(getUpgradeStorageById(id).getEffects());
		brewery.upgradeRoundlyCosts(getUpgradeStorageById(id).getRoundlyCosts());
	}
	public void buyUpgradeOutput(int id) {
		bank.payOut(getUpgradeOutputById(id).getCosts());
		brewery.upgradeOutput(getUpgradeOutputById(id).getEffects());
		brewery.upgradeRoundlyCosts(getUpgradeOutputById(id).getRoundlyCosts());
	}
}
