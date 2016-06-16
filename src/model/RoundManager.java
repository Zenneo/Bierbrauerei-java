package model;

public class RoundManager {

	// --variables--

	private int round = 0;
    private Bank bank;
    private Brewery brewery;
    private Upgrademanager upgrademanager;
    private Event event;
    private int sellOrderPrice;
    private int sellOrderBier;
	public int getRound() {
		return round;
	}

	public RoundManager() {
		bank = new Bank(10000);
		brewery = new Brewery(400, 50);
		upgrademanager = new Upgrademanager(bank, brewery);
		event = new Event();
		sellOrderPrice = 0;
		sellOrderBier = 0;
	}
	
	// does every operation and finishes a round if everything is valid 
	public void nextRound() {
		// TODO not done yet
		brewery.produce();
		bank.payOut(brewery.getRoundlyCosts());
		sell();
		
		// increment round counter
		round++;
	}
	public void purchaseUpgrade(int typ, int tier) {
		//typ = 0 => storage
		//typ = 1 => output
		if (typ == 0)
		{
			upgrademanager.buyUpgradeStorage(tier);
		} else if (typ == 1) {
			upgrademanager.buyUpgradeOutput(tier);
		}
	}
	public void placeSellOrder(int biermenge, int preis)
	{
		if (sellOrderBier == 0)
		{
			sellOrderBier = biermenge;
			sellOrderPrice = preis;
			brewery.removeBeer(biermenge);
		}
	}
	public boolean isSellable() //Überprüft ob etwas gekauft werden darf
	{
		if (sellOrderBier == 0)
		{
			return true;
		} else {
			return false;
		}
	}
	public void executeEvent()
	{
		
	}
	private void sell()
	{
		bank.payIn(sellOrderBier*sellOrderPrice*checkMarket());
		sellOrderBier = 0;
		sellOrderPrice = 0;
	}
	private int checkMarket() //Überprüft, weiviel der Menge zum gesetzten Preis verkauft werden kan
	{
		return 1;
	}
}
