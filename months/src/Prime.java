/**
 * 
 */


/**
 * @author Krishna
 *
 */
public class Prime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			if (i<=7 && i!=4 && i!=6) {
				System.out.println(i);//eliminates all non prime numbers less than 5
			}
		else if ((i%2!=0) && i%3!=0 && i%5!=0 && i%7!=0) {
			System.out.println(i);//Prints all prime numbers above 5
		}

	}

	}
}
