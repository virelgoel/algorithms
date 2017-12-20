/*
 * Find the factorial of a number
 * Used arbitrary array for memoization
 */
public class Factorial {
	
	public static long[] lookup = new long[32];
	
	public static long factorial(long n) {
		
		if (n <= 1) {
			return 1; 
		}
		else if (lookup[(int) n-1] > 0) {
			return lookup[(int) n-1];
		}
		
		lookup[(int) n-1] = n * factorial(n-1); 
		return lookup[(int) n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
}
