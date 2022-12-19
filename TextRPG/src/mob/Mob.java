package mob;

import java.util.Vector;

import item.Armor;
import item.Item;

public abstract class Mob {
	
	//Name of the mob
	private String name;
	
	//Living status
	private boolean isAlive = true;
	
	//Injured status
	private boolean isInjured = false;
	
	//Maximum carrying capacity
	private double carryCapacity = 0;
	
	//Vectors used for the inventory and health system, respectively
	//The health system is not done, so it has been commented out
	private Vector<Item> inventory;
	//private Vector<Injuries> health = new Vector<Injuries>(0);
	
	//What armor the mob is wearing.
	private Armor equippedArmor;
	
	private int healthPoints;

	//Generic Mob constructor, used for all living or dead creatures
	public Mob() {
		isAlive = true;
		isInjured = false;
		carryCapacity = 10;
		inventory = new Vector<Item>();
		equippedArmor = null;
		healthPoints = 100;
	}
	
	
	//Method to get the Mob's name
	public String getName() {
		return name;
	}

	//Method to set the Mob's name
	public void setName(String n) {
		name = n;
	}

	//Method to check if a Mob is alive
	public boolean isAlive() {
		return isAlive;
	}
	
	//Method to change Living status
	public void setAlive(boolean a) {
		isAlive = a;
	}
	
	//Method to check if the character is injured.
	public boolean isInjured() {
		return isInjured;
	}
	
	//Method to change Injured status
	public void setInjured(boolean inj) {
		isInjured = inj;
	}
	
	
	public double getCarryCapacity() {
		return carryCapacity;
	}
	
	
	public void setCarryCapacity(double capacity) {
		carryCapacity = capacity;
	}
	
	public Item getInventory(int i) {
		return inventory.elementAt(i);
	}
	
	public Vector<Item> getInventory() {
		return inventory;
	}
	
	
	//Method to add an Item to the inventory
	public Vector<Item> addInventory(Item it) {
		inventory.add(it);
		return inventory;
	}
	
	//Method to remove an item from the Mob's inventory
	public Vector<Item> removeInventory(Item item) {
		for (int i = 0; i < inventory.size(); i++)
			if (inventory.get(i).equals(item)) {
				if(inventory.get(i).getQuantity()<1)
					inventory.get(i).setQuantity(inventory.get(i).getQuantity() - 1);
				else
				{
					inventory.remove(i);
				}
			}
				
		return inventory;
	}
	
	//Method to set the current inventory
	public void setInventory(Vector<Item> inv) {
		inventory = inv;
	}
	
	public Armor getEquippedArmor() {
		return equippedArmor;
	}


	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}


	public int getHealthPoints() {
		return healthPoints;
	}


	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	
	public void tookDamage(double dmg) {
		if (equippedArmor == null)
			healthPoints = (int)(healthPoints - dmg);
		else
			healthPoints = (int)(healthPoints - equippedArmor.armorHit(dmg));
	}
	
	/*
	 * This block of text is for a health system, to be implemented
	 * later. This is kept here for later work.
	 * 
	 * 
	//Method to add an injury
	public void addInjuries() {
		health.add(null);
	}
	
	//Method to remove injuries. Triggered by healing time on the specific injury reaching 0
	public void removeInjuries() {
		
	}
	
	public void setInjuries(Vector<Injuries> newInj){
		health = newInj;		
	}
	 */
	
	

}
