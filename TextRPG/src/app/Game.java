package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import item.*;
import mob.*;
import vehicle.*;
import location.Space;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/9/2022	First made the program. Used to debug Mob objects.
 * Keith Davis		12/17/2022	Made the main program into a demonstration program.
 */

@SuppressWarnings("unused")
public class Game {


	public static Consumable[] medList;
	public static Consumable[] ammoList;
	public static Item[] itemList;
	public static Armor[] armorList;
	public static Gun[] gunList;
	public static Melee[] meleeList;
	public static SpaceShip[] shipList;
	public static Vector<SpaceShip> activeShipList = new Vector<SpaceShip>();
	public static Vector<String> allSaveNames = new Vector<String>();
	public static String saveName = null;
	public static String savesPath;
	public int score;


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean prevSaves = false;
		int choice = 0;

		//Initialize medical item list. Items that either add health, remove injuries,
		//or give a beneficial effect.
		if(!initItemList("Med")) {
			System.out.println("Medicine items failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		//Initialize Gun object list. CQC or long range weapons that require ammunition to do their
		//full damage output.
		if(!initItemList("Gun")) {
			System.out.println("Gun weapons failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		//Initialize Melee object list. CQC weapons that don't require ammunition.
		if(!initItemList("Melee")) {
			System.out.println("Melee weapons failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		//Initialize ammunition objects. Consumable used with Guns.
		if(!initItemList("Ammo")) {
			System.out.println("Ammunition failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		//Initialize Armor objects. Armor is an object worn to reduce damage taken.
		if(!initItemList("Armor")) {
			System.out.println("Armor failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		//Initialize Ship objects. Ships are just spaceships so far.
		if(!initItemList("Ship")) {
			System.out.println("Ships failed to initialize. Please redownload program");
			kb.close();
			return;
		}
		
		Human tester = new Human("Jerry", true, false, 35, new Vector<Item>(), null, 100);
		Human tester2 = new Human("Felix", true, false, 35, new Vector<Item>(), null, 100);
		System.out.println(tester.getName());
		System.out.println(tester2.getName());
		tester.addInventory(gunList[0]);
		System.out.println("Jerry was given a pistol");
		tester2.addInventory(armorList[0]);
		System.out.println("Felix was given some body armor");
		tester2.setEquippedArmor((Armor)tester2.getInventory(0));
		System.out.println("Felix equipped the Armor!");
		System.out.println("Jerry shot Felix!");
		tester.useItem(tester.getInventory(0), tester2);
		System.out.println("Felix's health is at " +tester2.getHealthPoints());
		tester2.addInventory(medList[0]);
		System.out.println("Felix was given some medicine.");
		System.out.println("Felix uses the medicine");
		tester2.useItem(tester2.getInventory(1), tester2);
		System.out.println("Felix's health is at " + tester2.getHealthPoints());
		
		
		/*
		//Initialize current save list
		//A list of all save names, that allow the program to find save file locations.
		if(!initItemList("Saves")) {
			System.out.println("Saves failed to initialize. Saves are either corrupt or nonexistent.");
			prevSaves = false;
		}
		else
			prevSaves = true;
		do {
			boolean check = false;
			do {
				mainMenu();
				if(!kb.hasNextInt()) {
					System.out.println("Incorrect input. Please try again");
					check = false;
				}
				else {
					choice = kb.nextInt();
					kb.nextLine();
					check = true;
				}
			}while (check != true); 
			switch (choice) {
			case 1:
				startNewGame(kb);
				
				break;
			case 2:
				if(prevSaves == false)
					System.out.println("No previous saves to load!");
				else {
					int choice1 = -1;
					do {
						System.out.println("Which save do you want to load?");
						for(int i = 0; i < allSaveNames.size(); i++) {
							System.out.println(i + " " + allSaveNames.elementAt(i));
						}
						System.out.print(">> ");

						if(kb.hasNextInt() == false) {
							System.out.println("Incorrect input. Please enter the number next to the save name.");
							choice1 = -1;
						}
						else
							choice1 = kb.nextInt();
						kb.nextLine();
					} while (choice1 == -1);

				}
				break;
			case 3:
				if(prevSaves == true) {
					System.out.println("Do you want to overwrite a save? Y/N");
					
				}
				else {
					System.out.println("What do you want your save to be named?");
					saveName = kb.nextLine();
					allSaveNames.add(saveName);
					writeSave();
					break;
				}
				break;
			case 4:
				break;
			default:
				System.out.println("Incorrect choice. Please select an item");
			}
			
		}while (choice != 4);
		*/
		kb.close();
	}
	//Main menu
	public static void mainMenu() {
		System.out.println("1. New game");
		System.out.println("2. Load game");
		System.out.println("3. Save game");
		System.out.println("4. Exit");

	}
	//Ship menu
	public static void shipMenu() {
		System.out.println("Fully capitalized words are commands.");
		System.out.println("1. Pull UP on the stick");
		System.out.println("2. Push DOWN on the stick");
		System.out.println("3. Tilt the stick LEFT");
		System.out.println("4. Tilt the stick RIGHT");
		System.out.println("5. Increase FORWARD velocity");
		System.out.println("6. Increase BACKWARD velocity");
		System.out.println("7. ROLL LEFT");
		System.out.println("8. ROLL RIGHT");
		System.out.println("9. STOP in space");
	}
	//Initializes any item types.
	public static boolean initItemList(String initType) {

		//File declarations
		Path file;

		//Boolean used for validating file access and path repair
		boolean foundDir = false;

		//Temporary variables used for rebuilding the file path.
		String temp1;
		int tempNum;
		StringBuilder tempPath;

		try {
			file = Paths.get("Game.java");
			file = file.toAbsolutePath();
			temp1 = file.toString();
			do {
				tempNum = temp1.indexOf("T");
				if(temp1.regionMatches(tempNum, "TextRPG", 0, 7)) {
					tempPath = new StringBuilder(temp1.substring(0, tempNum + 7));
					for(int i = 0; i < tempPath.length(); i++) {
						if (tempPath.charAt(i) == '\\' && foundDir == false) {
							tempPath.insert(i, "\\");
							foundDir = true;
						}
						else
							foundDir = false;
					}
					foundDir = true;
				}
				else {
					tempPath = new StringBuilder("");
					break;
				}
			}while(foundDir == false);
			if(foundDir == false)
				return false;

			if(initType == "Med")
				initMeds(tempPath.toString());
			if(initType == "Gun")
				initGuns(tempPath.toString());
			if(initType == "Melee")
				initMelee(tempPath.toString());
			if(initType == "Ammo")
				initAmmo(tempPath.toString());
			if(initType == "Armor")
				initArmor(tempPath.toString());
			if(initType == "Ship") {
				initShips(tempPath.toString());
			}
			if(initType == "Saves")
				initSaves(tempPath.toString());



			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;

		}

	}
	//Initializes all med objects
	private static void initMeds(String medPath) {

		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(medPath + "\\src\\item\\Medicine");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<Consumable> medlist = new Vector<Consumable>();
			Consumable medItem;
			String temp;
			int id;
			String nam;
			double wei;
			double val;
			String desc;
			int quan;
			boolean stk;
			int use;
			for (int i = 0; i < 3; i++) {
				temp = reader.readLine();
				id = Integer.parseInt(temp);
				nam = reader.readLine();
				temp = reader.readLine();
				wei = Double.parseDouble(temp);
				temp = reader.readLine();
				val = Double.parseDouble(temp);
				desc = reader.readLine();
				temp = reader.readLine();
				quan = Integer.parseInt(temp);
				temp = reader.readLine();
				stk = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				use = Integer.parseInt(temp);

				medItem = new Consumable(id, nam, wei, val, desc, quan, stk, use);
				medlist.add(medItem);
			}
			medList = new Consumable[medlist.size()];
			for(int i = 0; i < medlist.size(); i++)
				medList[i] = medlist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	//Initializes all med objects
	private static void initArmor(String armorPath) {
		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(armorPath + "\\src\\item\\Armor");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<Armor> armorlist = new Vector<Armor>();
			Armor armorItem;
			String temp;
			int id;
			String nam;
			double wei;
			double val;
			String desc;
			int quan;
			boolean stk;
			double dmgrd;
			for (int i = 0; i < 2; i++) {
				temp = reader.readLine();
				id = Integer.parseInt(temp);
				nam = reader.readLine();
				temp = reader.readLine();
				wei = Double.parseDouble(temp);
				temp = reader.readLine();
				val = Double.parseDouble(temp);
				desc = reader.readLine();
				temp = reader.readLine();
				quan = Integer.parseInt(temp);
				temp = reader.readLine();
				stk = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				dmgrd = Double.parseDouble(temp);

				armorItem = new Armor(id, nam, wei, val, desc, quan, stk, dmgrd);
				armorlist.add(armorItem);
			}
		armorList = new Armor[armorlist.size()];
		for(int i = 0; i < armorlist.size(); i++)
			armorList[i] = armorlist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	//Initializes all Gun objects.
	private static void initGuns(String gunPath) {
		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(gunPath + "\\src\\item\\Guns");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<Gun> gunlist = new Vector<Gun>();
			Gun gunItem;
			String temp;
			int id;
			String nam;
			double wei;
			double val;
			String desc;
			int quan;
			boolean stk;
			double dmg;
			double rng;
			int mag;
			int shots;
			int acc;

			for (int i = 0; i < 3; i++) {
				temp = reader.readLine();
				id = Integer.parseInt(temp);
				nam = reader.readLine();
				temp = reader.readLine();
				wei = Double.parseDouble(temp);
				temp = reader.readLine();
				val = Double.parseDouble(temp);
				desc = reader.readLine();
				temp = reader.readLine();
				quan = Integer.parseInt(temp);
				temp = reader.readLine();
				stk = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				dmg = Double.parseDouble(temp);
				temp = reader.readLine();
				rng = Double.parseDouble(temp);
				temp = reader.readLine();
				mag = Integer.parseInt(temp);
				temp = reader.readLine();
				shots = Integer.parseInt(temp);
				temp = reader.readLine();
				acc = Integer.parseInt(temp);

				gunItem = new Gun(id, nam, wei, val, desc, quan, stk, dmg, rng, mag, shots, acc);
				gunlist.add(gunItem);
			}
			gunList = new Gun[gunlist.size()];
			for(int i = 0; i < gunlist.size(); i++)
				gunList[i] = gunlist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}

	}
	//Initializes all Melee objects
	private static void initMelee(String meleePath) {

		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(meleePath + "\\src\\item\\Melee");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<Melee> meleelist = new Vector<Melee>();
			Melee meleeItem;
			String temp;
			int id;
			String nam;
			double wei;
			double val;
			String desc;
			int quan;
			boolean stk;
			double dmg;
			double rng;
			double atk;
			for (int i = 0; i < 2; i++) {
				temp = reader.readLine();
				id = Integer.parseInt(temp);
				nam = reader.readLine();
				temp = reader.readLine();
				wei = Double.parseDouble(temp);
				temp = reader.readLine();
				val = Double.parseDouble(temp);
				desc = reader.readLine();
				temp = reader.readLine();
				quan = Integer.parseInt(temp);
				temp = reader.readLine();
				stk = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				dmg = Double.parseDouble(temp);
				temp = reader.readLine();
				rng = Double.parseDouble(temp);
				temp = reader.readLine();
				atk = Double.parseDouble(temp);

				meleeItem = new Melee(id, nam, wei, val, desc, quan, stk, dmg, rng, atk);
				meleelist.add(meleeItem);
			}
			meleeList = new Melee[meleelist.size()];
			for(int i = 0; i < meleelist.size(); i++)
				meleeList[i] = meleelist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	//Initializes all Ammo objects
	private static void initAmmo(String ammoPath) {
		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(ammoPath + "\\src\\item\\Ammunition");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<Consumable> ammolist = new Vector<Consumable>();
			Consumable ammoItem;
			String temp;
			int id;
			String nam;
			double wei;
			double val;
			String desc;
			int quan;
			boolean stk;
			int use;
			for (int i = 0; i < 2; i++) {
				temp = reader.readLine();
				id = Integer.parseInt(temp);
				nam = reader.readLine();
				temp = reader.readLine();
				wei = Double.parseDouble(temp);
				temp = reader.readLine();
				val = Double.parseDouble(temp);
				desc = reader.readLine();
				temp = reader.readLine();
				quan = Integer.parseInt(temp);
				temp = reader.readLine();
				stk = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				use = Integer.parseInt(temp);

				ammoItem = new Consumable(id, nam, wei, val, desc, quan, stk, use);
				ammolist.add(ammoItem);
			}
			ammoList = new Consumable[ammolist.size()];
			for(int i = 0; i < ammolist.size(); i++)
				ammoList[i] = ammolist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}

	}
	//Initializes all SpaceShip objects
	private static void initShips(String spaceShipPath) {
		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		try {
			file = Paths.get(spaceShipPath + "\\src\\vehicle\\SpaceShips");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("An object file failed to open. Please redownload program");
				return;				
			}
			Vector<SpaceShip> shiplist = new Vector<SpaceShip>();
			SpaceShip shipItem;
			String temp;
			String nam;
			String eng;
			String fuel;
			int seat;
			double h;
			boolean hw;
			int wp;
			double wd;
			for (int i = 0; i < 2; i++) {
				nam = reader.readLine();
				eng = reader.readLine();
				fuel = reader.readLine();
				temp = reader.readLine();
				seat = Integer.parseInt(temp);
				temp = reader.readLine();
				h = Double.parseDouble(temp);
				temp = reader.readLine();
				hw = Boolean.parseBoolean(temp);
				temp = reader.readLine();
				wp = Integer.parseInt(temp);
				temp = reader.readLine();
				wd = Double.parseDouble(temp);

				shipItem = new SpaceShip(nam, eng, fuel, seat, h, hw, wp, wd);
				shiplist.add(shipItem);
			}
			shipList = new SpaceShip[shiplist.size()];
			for(int i = 0; i < shiplist.size(); i++)
				shipList[i] = shiplist.elementAt(i);
		}catch(IOException i) {
			i.printStackTrace();
		}

	}
	//Initializes the save name list
	private static void initSaves(String savePath) {
		//File declarations
		Path file;
		BufferedReader reader;
		InputStream inFile;
		String temp;
		try {
			savePath = savePath + "\\src\\Saves";
			savesPath = savePath;
			file = Paths.get(savePath + "\\SaveNameList");
			inFile = Files.newInputStream(file);
			reader = new BufferedReader(new InputStreamReader(inFile));

			//Reader verification
			if(!reader.ready()) {
				System.out.println("The save file list failed to open. Previous saves unavailable");
				return;				
			}
			Vector<String> savesList = new Vector<String>();
			do {
				temp = reader.readLine();
				if (temp == null)
					break;
				else {
					savesList.add(temp);
				}
			} while (temp != null);
			for (int i = 0; i < savesList.size(); i++) {
				allSaveNames.add(savesList.elementAt(i));
			}
		}catch(IOException i) {
			i.printStackTrace();
		}

	}
	public static void startNewGame(Scanner kb) {
		String temp;
		activeShipList.add(shipList[0]);
		Space.space[220][225][300] = activeShipList.elementAt(0);
		activeShipList.add(shipList[1]);
		Space.space[485][341][223] = activeShipList.elementAt(1);
		activeShipList.elementAt(1).setTeam(1);
		System.out.println("There are " + (activeShipList.size() - 1) + " ships on the field. Destroy them.");
		do {
			
			shipMenu();
			temp = kb.nextLine();
			activeShipList.elementAt(0).moveShip(temp);
		} while (activeShipList.elementAt(1).getName() != "Lifeboat");
	}
	/*
	//Writes save data to a file
	public static void writeSave(){
		try
		{
			File files;
			FileWriter fileWriter = null;

			//Output file open
			File dir = new File(savesPath + "\\" + saveName);
			if (!dir.exists())
				dir.mkdir();					
			files = new File(savesPath + "\\" + saveName + "\\" + saveName);
			if (!files.exists())
				files.createNewFile();
			fileWriter = new FileWriter(files);

			//Main processing
			BufferedWriter outputFile = new BufferedWriter(fileWriter);

			outputFile.append("This doesn't work yet.");
			outputFile.close();

		}catch (IOException e) {
			System.out.println(e);
		}
	}
	//Writes scores to a file
	public static void writeScore() {

	}
	*/


}
