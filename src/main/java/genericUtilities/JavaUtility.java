package genericUtilities;

import java.util.Random;

public class JavaUtility {
	/**
	 * this method will generate a random number,
	 * in the given range as the parameter for this method.
	 * @param int range
	 * @return integer
	 */
	public int generateRandomNumber(int range) {
		Random r= new Random();
		return 	r.nextInt(range);
	}
}
