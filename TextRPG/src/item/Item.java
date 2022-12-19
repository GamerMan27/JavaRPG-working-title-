package item;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/7/2022	Implementation
 * Keith Davis		12/9/2022	Changed Item variables and constructors.
 * 
 * This class is used to instantiate any item, but 
 * is used mainly to instantiate objects from a subclass
 * or random generic/key items
 */

public class Item {
	
	//Item Code
	private int IDCode;
	
	//Item Name
	private String name;
	
	//Weight of item
	private double weight;
	
	//Value if sold
	private double value;
	
	//Item description
	private String description;
	
	private int quantity;
	
	private boolean canStack = false;
	
	
		
	//Default Item constructor
	public Item() {
		setIDCode(0);
		setName("");
		setWeight(0);
		setValue(0);
		setDescription("");
		setQuantity(1);
		setCanStack(true);
	}
	
	//Specific Item constructor
	public Item(int ID, String n, double w, double v, String dd, int q, boolean s) {
		setIDCode(ID);
		setName(n);
		setWeight(w);
		setValue(v);
		setDescription(dd);
		setQuantity(q);
		setCanStack(s);
	}

	public int getIDCode() {
		return IDCode;
	}

	public void setIDCode(int iDCode) {
		this.IDCode = iDCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
	public boolean isCanStack() {
		return canStack;
	}

	public void setCanStack(boolean canStack) {
		this.canStack = canStack;
	}

	//Equals function for comparing Item objects
	public boolean equals(Item it) {
		if(this.IDCode == it.IDCode)
			return true;
		else
			return false;
	}
}
