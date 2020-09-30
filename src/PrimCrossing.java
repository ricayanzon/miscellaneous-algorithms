
/*
 * The method crossPrim(n) calculates the sum of all 
 * prime numbers p < n whose digit sum is even.
 * 
 * Without using the Java standard library.
 * 
 * */

public class PrimCrossing {

	
	public static int crossPrim(int n) {
		
		int result = 0;
		
		for(int i = 2; i < n; i++) {
			
			if(isPrime(i)) {
				
				int sum = calcDigitSum(i);
				
				/* if sum of digits of i even, add i to result */
				
				if(sum % 2 == 0) {
					
					result += i;
					
				}
				
			}
				
		}
		
		if(n < 2) return 0;
		
		if(n == 2) return 2;
		
		return result;
		
	}
	
	
	/* returns true if i is prime, otherwise false */
	
	private static boolean isPrime(int i) {
		
		for(int j = 2; j < i; j++) {
			
			if(i % j == 0) return false;
			
		}
		
		return true;
		
	}
	
	/* calculates the sum of the digits of passed parameter i */

	private static int calcDigitSum(int i) {
		
		int tmp = 0;
		
		while(i > 0) {
			
			tmp += i % 10;
			i /= 10;
			
		}
		
		return tmp;
		
	}

}
