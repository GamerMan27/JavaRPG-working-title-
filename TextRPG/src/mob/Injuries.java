package mob;

import item.Consumable;

//This class will be used later in the health system. As of yet
//it is unfinished.

public class Injuries {
	private static final String[] TYPES = {"Gunshot", "Laceration", "Stab", "Blunt Force"};
	
	private String type;
	private String location;
	private String description;
	private Consumable neededMed;
	private int healTime;
	
	private Consumable[] meds = new Consumable[3];
	
	
	public Injuries() {
		type = "Gunshot";
		location = "Left arm";
		description = "Blood gushes from an open hole in your arm.";
		neededMed = meds[1];
		healTime = 2;
	}
	
}
