package location;
import vehicle.SpaceShip;

public class Space {
	public static final int MAX_X = 500;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 500;
	public static final int MIN_Y = 0;
	public static final int MAX_Z = 500;
	public static final int MIN_Z = 0;
	public static SpaceShip[][][] space = new SpaceShip[MAX_X][MAX_Y][MAX_Z];
	
	public static void shipMoved(SpaceShip s) {
		if(s.getFront() == "x+") {
			
		}
		
	}
	
}