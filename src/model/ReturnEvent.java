package model;

public class ReturnEvent {
     private String eventName;
     private String eventDescription;
     private int eventPrice;
     private int eventAmount;
     private int eventDurability;
     public ReturnEvent(String Name, String Description, int Price, int Amount, int Durability)
     {
    	 eventName = Name;
    	 eventDescription = Description;
    	 eventPrice = Price;
    	 eventAmount = Amount;
    	 eventDurability = Durability;
     }
     public String geteventName()
     {
    	 return eventName;
     }
     public String geteventDescription()
     {
    	 return eventDescription;
     }
     public int geteventPrice()
     {
    	 return eventPrice;
     }
     public int geteventAmount()
     {
    	 return eventAmount;
     }
     public int geteventDurability()
     {
    	 return eventDurability;
     }
}
