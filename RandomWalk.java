import java.util.Random;

/**
 * 
 * @author Noah Burnette
 * @version 8/21/21 Project 1 CSCI202- Introduction to Data Structures
 * 
 *          RandomWalk class consists of an instance variable array roomSize.
 * 
 *
 **/
public class RandomWalk {
	// Default width for constructor
	final int WIDTH = 4;
	// Default length for constructor
	final int LENGTH = 5;
	private Random rando = new Random();
	private int[][] roomSize;
	private int totalSteps;
	private int bugPositionWidth;
	private int bugPositionLength;

	/**
	 * Default constructor that uses constants for the array size
	 */
	public RandomWalk() {
		this.roomSize = new int[LENGTH][WIDTH];
	}

	/**
	 * 
	 * @param width-  Determines the horizontal length of the array
	 * @param length- Determines the vertical length of the array The 2nd
	 *                
	 * constructor that takes arguments instead of default.
	 */
	public RandomWalk(int width, int length) {
		this.roomSize = new int[length][width];
	}

	/**
	 * 
	 * @return totalSteps- returns how many steps the bug has taken. Not including
	 *         the initial placement. 
	 * simple getter method.
	 * 
	 */
	public int getTotalSteps() {
		return totalSteps;
	}

	/**
	 * 
	 * @return roomLayout- returns the array that is formatted as a string 
	 * This functions as a "toString()" but with a different name.
	 * 
	 */
	public String printRoom() {
		String roomLayout = "\t\n";

		for (int i = 0; i < roomSize.length; i++) {
			for (int k = 0; k < roomSize[0].length; k++) {
				roomLayout += "" + roomSize[i][k] + " \t" ;
			}
			roomLayout += "\n\t\n";
		}

		return roomLayout;
	}

	/**
	 * nextMove() determines where the bug will be going next. uses the Random class
	 * to assign the bug one of eight places, assuming it's not next to a wall
	 */
	private void nextMove() {
		int moveWidth = rando.nextInt(3) - 1;
		int moveLength = rando.nextInt(3) - 1;

		// This ensures the left and right walls are impassable
		while (bugPositionWidth + moveWidth < 0 | bugPositionWidth + moveWidth > roomSize[0].length - 1
				| (moveWidth == 0 & moveLength == 0)) {

			moveWidth = rando.nextInt(3) - 1;
		}
		// This ensures the top and bottom walls are impassable
		while (bugPositionLength + moveLength < 0 | bugPositionLength + moveLength > roomSize.length - 1
				| (moveWidth == 0 & moveLength == 0)) {

			moveLength = rando.nextInt(3) - 1;

		}
		bugPositionWidth += moveWidth;
		bugPositionLength += moveLength;

	}

	/**
	 * 
	 * runBug() initializes the bug's starting position. Then uses nextMove() to
	 * ensure the bug's path is viable. adds to totalSteps finally checks to see if
	 * every space has been filled.
	 * 
	 */
	public void runBug() {
		Boolean running = true;
		int spacesFilled = 0;
		bugPositionWidth = rando.nextInt(roomSize[0].length);
		bugPositionLength = rando.nextInt(roomSize.length);

		while (running) {
			roomSize[bugPositionLength][bugPositionWidth]++;
			nextMove();
			totalSteps++;
			spacesFilled = 0;

			for (int i = 0; i < roomSize.length; i++) {
				for (int k = 0; k < roomSize[0].length; k++) {
					// Checks the current "space" to check if it is filled.
					if (roomSize[i][k] > 0)
						spacesFilled++;
					if (spacesFilled == roomSize.length * roomSize[0].length) {
						System.out.println(printRoom() + "\nTotal steps: " + getTotalSteps() + "\n");
						running = false;
					}

				}

			}

		}

	}

}
