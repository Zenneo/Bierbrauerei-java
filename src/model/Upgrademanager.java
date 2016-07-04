package model;

public class Upgrademanager {
	// This class manages the upgrades
	
	// --variables--
	
	private Bank bank;
	private Brewery brewery;
	private Upgrade[] upgradesStorage;
	private Upgrade[] upgradesOutput;
	
	public Upgrademanager(Bank bank_ini, Brewery brewery_ini) {
		bank = bank_ini;
		brewery = brewery_ini;
		upgradesStorage = new Upgrade[3];
		upgradesOutput = new Upgrade[3];
		setUpgrades();
	}

	private void setUpgrades() {
		for (int id = 0; id < 3; id++) {
			upgradesStorage[id] = new Upgrade(id, bank);
		}
		for (int id = 0; id < 3; id++) {
			upgradesOutput[id] = new Upgrade(id+3, bank);
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
