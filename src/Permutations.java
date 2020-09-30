/*
 * Calculates all permutations for an (unsigned) integer.
 * 
 * */

public class Permutations {
	
	private int num, result;
	
	public Permutations(int n) {
		
		if(n < 0) {
			
			this.num = 0;
			
		}
		else {

			this.num = n;
			
		}
		
	}
	
	
	public void setNum(int n) {
		this.num = n;
	}
	

	public String toString() {
		return this.permutate() + "";
	}
	
	
	public int permutate() {
		
		if(num < 2) return 1;
		
		this.result = 1;
		
		return num * recPermutate(num-1);
	}
	
	
	/*
	 * Number of permutations equals num!.
	 * 
	 * */
	
	public int recPermutate(int num) {
		
		if(num < 3) {
			
			return num;
			
		}
		
		result *= num * recPermutate(num-1);
		
		return result;
		
	}
	
}