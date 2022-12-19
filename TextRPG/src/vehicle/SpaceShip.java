package vehicle;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/17/2022	Implementation
 * 
 * This class implements ships meant to move in 3d space. It also implements
 * methods to move said ships.
 */



public class SpaceShip extends Vehicle{
		
	private final String MOVE[] = {"UP", "DOWN", "LEFT", "RIGHT", "FORWARD", "BACKWARD", "ROLL LEFT", "ROLL RIGHT", "STOP"};
	
	private String top = "z+";
	private String left = "y-";
	private String front = "x+";
	
	private int velocity;
	
	public SpaceShip() {
		super();
	}
	public SpaceShip(String n, String eng, String f, int s, double h, boolean hw, int wp, double wd) {
		super(n, eng, f, s, h, hw, wp, wd);
	}
	public SpaceShip(String n, String eng, String f, int s, double h, boolean hw, int wp, double wd, int t) {
		super(n, eng, f, s, h, hw, wp, wd, t);
	}
	
	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String leftSide) {
		this.left = leftSide;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}
	
	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public void moveShip(String dir) {
		if(dir.toUpperCase() == MOVE[0]) {
			System.out.println("You pull your stick upwards.");
			if(this.getFront() == "x+") {
				if(this.getTop() == "z+") {
					setFront("z+");
					setTop("x-");
				}
				else if(this.getTop() == "y+") {
					setFront("y+");
					setTop("x-");
				}
				else if(this.getTop() == "z-") {
					setFront("z-");
					setTop("x-");
				}
				else if(this.getTop() == "y-") {
					setFront("y-");
					setTop("x-");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getTop() == "z+") {
					setFront("z+");
					setTop("x+");
				}
				else if(this.getTop() == "y+") {
					setFront("y+");
					setTop("x+");
				}
				else if(this.getTop() == "z-") {
					setFront("z-");
					setTop("x+");
				}
				else if(this.getTop() == "y-") {
					setFront("y-");
					setTop("x+");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getTop() == "z+") {
					setFront("z+");
					setTop("y-");
				}
				else if(this.getTop() == "x+") {
					setFront("x+");
					setTop("y-");
				}
				else if(this.getTop() == "z-") {
					setFront("z-");
					setTop("y-");
				}
				else if(this.getTop() == "x-") {
					setFront("x-");
					setTop("y-");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getTop() == "z+") {
					setFront("z+");
					setTop("y+");
				}
				else if(this.getTop() == "x+") {
					setFront("x+");
					setTop("y+");
				}
				else if(this.getTop() == "z-") {
					setFront("z-");
					setTop("y+");
				}
				else if(this.getTop() == "x-") {
					setFront("x-");
					setTop("y+");					
				}
			}
			else if(getFront() == "z+") {
				if(this.getTop() == "x+") {
					setFront("x+");
					setTop("z-");
				}
				else if(this.getTop() == "y+") {
					setFront("y+");
					setTop("z-");
				}
				else if(this.getTop() == "x-") {
					setFront("x-");
					setTop("z-");
				}
				else if(this.getTop() == "y-") {
					setFront("y-");
					setTop("z-");					
				}
			}
			else if(getFront() == "z-") {
				if(this.getTop() == "x+") {
					setFront("x+");
					setTop("z+");
				}
				else if(this.getTop() == "y+") {
					setFront("y+");
					setTop("z+");
				}
				else if(this.getTop() == "x-") {
					setFront("x-");
					setTop("z+");
				}
				else if(this.getTop() == "y-") {
					setFront("y-");
					setTop("z+");					
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[1]) {
			System.out.println("You push your throttle downwards.");
			if(this.getFront() == "x+") {
				if(this.getTop() == "z+") {
					setFront("z-");
					setTop("x+");
				}
				else if(this.getTop() == "y+") {
					setFront("y-");
					setTop("x+");
				}
				else if(this.getTop() == "z-") {
					setFront("z+");
					setTop("x+");
				}
				else if(this.getTop() == "y-") {
					setFront("y+");
					setTop("x+");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getTop() == "z+") {
					setFront("z-");
					setTop("x-");
				}
				else if(this.getTop() == "y+") {
					setFront("y-");
					setTop("x-");
				}
				else if(this.getTop() == "z-") {
					setFront("z+");
					setTop("x-");
				}
				else if(this.getTop() == "y-") {
					setFront("y+");
					setTop("x-");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getTop() == "z+") {
					setFront("z-");
					setTop("y+");
				}
				else if(this.getTop() == "x+") {
					setFront("x-");
					setTop("y+");
				}
				else if(this.getTop() == "z-") {
					setFront("z+");
					setTop("y+");
				}
				else if(this.getTop() == "x-") {
					setFront("x+");
					setTop("y+");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getTop() == "z+") {
					setFront("z-");
					setTop("y-");
				}
				else if(this.getTop() == "x+") {
					setFront("x-");
					setTop("y-");
				}
				else if(this.getTop() == "z-") {
					setFront("z+");
					setTop("y-");
				}
				else if(this.getTop() == "x-") {
					setFront("x+");
					setTop("y-");					
				}
			}
			else if(getFront() == "z+") {
				if(this.getTop() == "x+") {
					setFront("x-");
					setTop("z+");
				}
				else if(this.getTop() == "y+") {
					setFront("y-");
					setTop("z+");
				}
				else if(this.getTop() == "x-") {
					setFront("x+");
					setTop("z+");
				}
				else if(this.getTop() == "y-") {
					setFront("y+");
					setTop("z+");					
				}
			}
			else if(getFront() == "z-") {
				if(this.getTop() == "x+") {
					setFront("x-");
					setTop("z-");
				}
				else if(this.getTop() == "y+") {
					setFront("y-");
					setTop("z-");
				}
				else if(this.getTop() == "x-") {
					setFront("x+");
					setTop("z-");
				}
				else if(this.getTop() == "y-") {
					setFront("y+");
					setTop("z-");					
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[2]) {
			System.out.println("You pull your throttle leftwards.");
			if(this.getFront() == "x+") {
				if(this.getTop() == "z+") {
					setFront("y-");
					setLeft("x-");
				}
				else if(this.getTop() == "y+") {
					setFront("z+");
					setLeft("x-");
				}
				else if(this.getTop() == "z-") {
					setFront("y+");
					setLeft("x-");
				}
				else if(this.getTop() == "y-") {
					setFront("z-");
					setLeft("x-");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getTop() == "z+") {
					setFront("y+");
					setLeft("x+");
				}
				else if(this.getTop() == "y+") {
					setFront("z+");
					setLeft("x+");
				}
				else if(this.getTop() == "z-") {
					setFront("y-");
					setLeft("x+");
				}
				else if(this.getTop() == "y-") {
					setFront("z-");
					setLeft("x+");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getTop() == "z+") {
					setFront("x-");
					setLeft("y-");
				}
				else if(this.getTop() == "x+") {
					setFront("z+");
					setLeft("y-");
				}
				else if(this.getTop() == "z-") {
					setFront("x+");
					setLeft("y-");
				}
				else if(this.getTop() == "x-") {
					setFront("z-");
					setLeft("y-");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getTop() == "z+") {
					setFront("x+");
					setLeft("y+");
				}
				else if(this.getTop() == "x+") {
					setFront("z-");
					setLeft("y+");
				}
				else if(this.getTop() == "z-") {
					setFront("x-");
					setLeft("y+");
				}
				else if(this.getTop() == "x-") {
					setFront("z+");
					setLeft("y+");					
				}
			}
			else if(getFront() == "z+") {
				if(this.getTop() == "x+") {
					setFront("y-");
					setLeft("z-");
				}
				else if(this.getTop() == "y+") {
					setFront("x+");
					setLeft("z-");
				}
				else if(this.getTop() == "x-") {
					setFront("y+");
					setLeft("z-");
				}
				else if(this.getTop() == "y-") {
					setFront("x-");
					setLeft("z-");					
				}
			}
			else if(getFront() == "z-") {
				if(this.getTop() == "x+") {
					setFront("y-");
					setLeft("z+");
				}
				else if(this.getTop() == "y+") {
					setFront("x-");
					setLeft("z+");
				}
				else if(this.getTop() == "x-") {
					setFront("y-");
					setLeft("z+");
				}
				else if(this.getTop() == "y-") {
					setFront("x+");
					setLeft("z+");					
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[3]) {
			System.out.println("You pull your throttle rightwards.");
			if(this.getFront() == "x+") {
				if(this.getTop() == "z+") {
					setFront("y-");
					setLeft("x+");
				}
				else if(this.getTop() == "y+") {
					setFront("z+");
					setLeft("x+");
				}
				else if(this.getTop() == "z-") {
					setFront("y+");
					setLeft("x+");
				}
				else if(this.getTop() == "y-") {
					setFront("z-");
					setLeft("x+");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getTop() == "z+") {
					setFront("y+");
					setLeft("x-");
				}
				else if(this.getTop() == "y+") {
					setFront("z-");
					setLeft("x-");
				}
				else if(this.getTop() == "z-") {
					setFront("y-");
					setLeft("x-");
				}
				else if(this.getTop() == "y-") {
					setFront("z+");
					setLeft("x-");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getTop() == "z+") {
					setFront("x+");
					setLeft("y+");
				}
				else if(this.getTop() == "x+") {
					setFront("z-");
					setLeft("y+");
				}
				else if(this.getTop() == "z-") {
					setFront("x-");
					setLeft("y+");
				}
				else if(this.getTop() == "x-") {
					setFront("z+");
					setLeft("y+");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getTop() == "z+") {
					setFront("x-");
					setLeft("y-");
				}
				else if(this.getTop() == "x+") {
					setFront("z+");
					setLeft("y-");
				}
				else if(this.getTop() == "z-") {
					setFront("x+");
					setLeft("y-");
				}
				else if(this.getTop() == "x-") {
					setFront("z-");
					setLeft("y-");					
				}
			}
			else if(getFront() == "z+") {
				if(this.getTop() == "x+") {
					setFront("y+");
					setLeft("z+");
				}
				else if(this.getTop() == "y+") {
					setFront("x-");
					setLeft("z+");
				}
				else if(this.getTop() == "x-") {
					setFront("y-");
					setLeft("z+");
				}
				else if(this.getTop() == "y-") {
					setFront("x+");
					setLeft("z+");					
				}
			}
			else if(getFront() == "z-") {
				if(this.getTop() == "x+") {
					setFront("y-");
					setLeft("z-");
				}
				else if(this.getTop() == "y+") {
					setFront("x-");
					setLeft("z-");
				}
				else if(this.getTop() == "x-") {
					setFront("y+");
					setLeft("z-");
				}
				else if(this.getTop() == "y-") {
					setFront("x+");
					setLeft("z-");					
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[4]) {
			System.out.println("You engage the main thruster, propelling your ship forwards.");
			setVelocity(getVelocity() + 1);
		}
		else if(dir.toUpperCase() == MOVE[5]) {
			System.out.println("You engage the forward thrusters, propelling your ship backwards.");
			setVelocity(getVelocity() - 1);
		}
		else if(dir.toUpperCase() == MOVE[6]) {
			System.out.println("You roll your ship leftwards");
			if(this.getFront() == "x+") {
				if(this.getLeft() == "z+") {
					setLeft("y+");
					setTop("z+");
				}
				else if(this.getLeft() == "y+") {
					setLeft("z-");
					setTop("y+");
				}
				else if(this.getLeft() == "z-") {
					setLeft("y-");
					setTop("z-");
				}
				else if(this.getLeft() == "y-") {
					setLeft("z+");
					setTop("y-");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getLeft() == "z+") {
					setLeft("y-");
					setTop("z+");
				}
				else if(this.getLeft() == "y+") {
					setLeft("z+");
					setTop("y+");
				}
				else if(this.getLeft() == "z-") {
					setLeft("y+");
					setTop("z-");
				}
				else if(this.getLeft() == "y-") {
					setLeft("z-");
					setTop("y-");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getLeft() == "z+") {
					setLeft("x-");
					setTop("z+");
				}
				else if(this.getLeft() == "x+") {
					setLeft("z+");
					setTop("x+");
				}
				else if(this.getLeft() == "z-") {
					setLeft("x+");
					setTop("z-");
				}
				else if(this.getLeft() == "x-") {
					setLeft("z-");
					setTop("x-");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getLeft() == "z+") {
					setLeft("x+");
					setTop("z+");
				}
				else if(this.getLeft() == "x+") {
					setLeft("z-");
					setTop("x+");
				}
				else if(this.getLeft() == "z-") {
					setLeft("x-");
					setTop("z-");
				}
				else if(this.getLeft() == "x-") {
					setLeft("z+");
					setTop("x-");					
				}
			}
			else if(getFront() == "z+") {
				if(this.getLeft() == "x+") {
					setLeft("y+");
					setTop("x+");
				}
				else if(this.getLeft() == "y+") {
					setLeft("x-");
					setTop("y+");
				}
				else if(this.getLeft() == "x-") {
					setLeft("y-");
					setTop("x-");
				}
				else if(this.getLeft() == "y-") {
					setLeft("x+");
					setTop("y-");					
				}
			}
			else if(getFront() == "z-") {
				if(this.getLeft() == "x+") {
					setLeft("y+");
					setTop("x+");
				}
				else if(this.getLeft() == "y+") {
					setLeft("x-");
					setTop("y+");
				}
				else if(this.getLeft() == "x-") {
					setLeft("y-");
					setTop("x-");
				}
				else if(this.getLeft() == "y-") {
					setLeft("x+");
					setTop("-y");					
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[7]) {
			System.out.println("You roll your ship rightwards.");
			if(this.getFront() == "x+") {
				if(this.getTop() == "z+") {
					setLeft("z+");
					setTop("y-");
				}
				else if(this.getTop() == "y+") {
					setLeft("y+");
					setTop("z+");
				}
				else if(this.getTop() == "z-") {
					setLeft("z-");
					setTop("y+");
				}
				else if(this.getTop() == "y-") {
					setLeft("y-");
					setTop("z-");					
				}
			}
			else if(getFront() == "x-") {
				if(this.getTop() == "z+") {
					setLeft("z+");
					setTop("y+");
				}
				else if(this.getTop() == "y+") {
					setLeft("y+");
					setTop("z-");
				}
				else if(this.getTop() == "z-") {
					setLeft("z-");
					setTop("y-");
				}
				else if(this.getTop() == "y-") {
					setLeft("y-");
					setTop("z+");					
				}
			}
			else if(getFront() == "y+") {
				if(this.getTop() == "z+") {
					setLeft("z+");
					setTop("x+");
				}
				else if(this.getTop() == "x+") {
					setLeft("x+");
					setTop("z-");
				}
				else if(this.getTop() == "z-") {
					setLeft("z-");
					setTop("x-");
				}
				else if(this.getTop() == "x-") {
					setLeft("x-");
					setTop("z+");					
				}
			}
			else if(getFront() == "y-") {
				if(this.getTop() == "z+") {
					setLeft("z+");
					setTop("x-");
				}
				else if(this.getTop() == "x+") {
					setLeft("x+");
					setTop("z+");
				}
				else if(this.getTop() == "z-") {
					setLeft("z-");
					setTop("x+");
				}
				else if(this.getTop() == "x-") {
					setLeft("x-");
					setTop("z-");
				}
			}
			else if(getFront() == "z+") {
				if(this.getTop() == "x+") {
					setLeft("x+");
					setTop("y+");
				}
				else if(this.getTop() == "y+") {
					setLeft("y+");
					setTop("x-");
				}
				else if(this.getTop() == "x-") {
					setLeft("x-");
					setTop("y-");
				}
				else if(this.getTop() == "y-") {
					setLeft("y-");
					setTop("x+");
				}
			}
			else if(getFront() == "z-") {
				if(this.getTop() == "x+") {
					setLeft("x+");
					setTop("y-");
				}
				else if(this.getTop() == "y+") {
					setLeft("y+");
					setTop("x+");
				}
				else if(this.getTop() == "x-") {
					setLeft("x-");
					setTop("y+");
				}
				else if(this.getTop() == "y-") {
					setLeft("y-");
					setTop("x-");
				}
			}
		}
		else if(dir.toUpperCase() == MOVE[8]) {
			System.out.println("You engage inertial thrusters, stopping your ship in space.");
			setVelocity(0);
		}
	}
}
