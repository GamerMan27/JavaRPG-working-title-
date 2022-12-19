package item;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/8/2022	Implemented Consumable class
 * Keith Davis		12/10/2022	Changed constructors to fit changes to Item
 * 
 * This class encompasses all items that are consumed on use.
 * It includes medical items and ammunition.
 */

public class Consumable extends Item{
	private int uses;
	
	//Default constructor
	public Consumable() {
		super();
		setUses(1);
		
	}
	
	//Constructor with only uses specified
	public Consumable(int us) {
		super();
		setUses(us);
		
	}
	
	//Constructor with only superclass parameters
	public Consumable(int ID, String n, double w, double v, String dd, int q, boolean s) {
		super(ID, n, w, v, dd, q, s);
		setUses(1);
	}
	
	//Constructor with all parameters.
	public Consumable(int ID, String n, double w, double v, String dd, int q, boolean s, int us) {
		super(ID, n, w, v, dd, q, s);
		setUses(us);
	}
	
		
	public void used() {
		uses -= 1;
		if (uses == 0)
			this.setQuantity(this.getQuantity() - 1);
	}

	
	public int getUses() {
		return uses;
	}

	
	public void setUses(int uses) {
		this.uses = uses;
	}
	
}
