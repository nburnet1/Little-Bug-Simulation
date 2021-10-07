/**
 * 
 * @author Noah Burnette
 * @version 8/21/21 
 * 
 *          Main class simply holds the main method.
 *
 **/
public class Main {
	/**
	 * 
	 * @param args this main method creates the objects needed to ensure code is
	 *             running properly.
	 * 
	 */
	public static void main(String[] args) {

		RandomWalk bug0 = new RandomWalk(10,10);
		RandomWalk bug1 = new RandomWalk(6, 7);
		RandomWalk bug2 = new RandomWalk();
		RandomWalk bug3 = new RandomWalk(5, 3);
		RandomWalk bug4 = new RandomWalk(2, 2);

		bug0.runBug();
		bug1.runBug();
		bug2.runBug();
		bug3.runBug();
		bug4.runBug();

	}

}
