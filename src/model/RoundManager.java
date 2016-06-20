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
    private String eventName;
    private String eventDescription;
    private int eventPrice;
    private int eventAmount;
    private int eventDurability;
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
		eventName = "";
		eventDescription = "";
		eventPrice = 0;
		eventAmount = 0;
		eventDurability = 0;
	}
	
	// does every operation and finishes a round if everything is valid 
	public void nextRound() {
		// TODO not done yet
		brewery.produce();
		bank.payOut(brewery.getRoundlyCosts());
		sell();
		eventDurability = eventDurability - 1;
		if (eventName == "" || eventDurability < 1)
		{
			getNewEvent();
		}
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
		bank.payIn(eventPrice);
		brewery.removeBeer(eventAmount);
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
	private void getNewEvent()
	{
		ReturnEvent newEvent = event.getEvent(round);
		eventName = newEvent.geteventName();
		eventDescription = newEvent.geteventDescription();
		eventPrice = newEvent.geteventPrice();
		eventAmount = newEvent.geteventAmount();
		eventDurability = newEvent.geteventDurability();
	}
	public boolean checkEventAvailability()
	{
		if (eventName == "")
		{
			return false;
		} else if (eventName != "") {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkEventPosibility()
	{
		if (eventAmount <= brewery.getStorage())
		{
			return true;
		} else {
			return false;
		}
	}
}
