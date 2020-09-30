
/*
 * Handle strings just using .charAt(position), .length(), and Integer.parseInt(String s)
 * 
 * */

public class Stringulina {
	
	
	/* finds the needle in the haystack */
	
	public static int substringPos(String haystack, String needle) {
		
		int firstStartingLocation;
		
		for(int i = 0; i < haystack.length(); i++) {
			
			int j = 0;
			firstStartingLocation = i;
			
			while(i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
				
				i++; 
				j++;
				if(j == needle.length()) return firstStartingLocation;
				
			}
			
		}
		
		return -1;
		
	}
	
	
	/* counts how often one string is in another (e.g. "aa" is 3 times in "aaaa") */
	
	public static int countSubstring(String haystack, String needle) {

		int count = 0;

		int j;
		int tmp;
		
		for(int i = 0; i < haystack.length(); i++) {
			
			j = 0;
			tmp = i;
			
			while(i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
				
				i++; 
				j++;
				
				if(j == needle.length()) {
					count++;
				}
				
			}

			i = tmp;
			
		}
		
		return count;
		
	}
	
	
	/* 
	 * checks if each opening bracket is followed by a closing bracket, so
	 * that there's the same amount of opening brackets than closing ones.
	 * also, a closing bracket can only come after an opening bracket.
	 * 
	 * */

	public static boolean correctlyBracketed(String str) {
		
		char opening = '(';
		char closing = ')';
		
		/* 
		 * each opening bracket increments the value of count by 1,
		 * each closing bracket decrements the value of count by 1.
		 * if count equals 0, there are as many opening as there are closing brackets
		 * 
		 *  */
		
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == opening) { count++; }
			
			if(str.charAt(i) == closing) { count--; }
			
			if(count < 0) { return false; }
			
		}
		
		if(count == 0) { return true; }
		
		else { return false; }
		
		
	}
	
	
	/*
	 * checks if a string consisting of small and capital letters (a-z
	 * and A-Z) matches the given pattern. 
	 * 
	 * a pattern can contain two special constructs besides letters: 
	 * 
	 * 		1. a dot ('.'), which matches any letter
	 * 		2. behind a letter or a dot a multiplicity can be specified
	 * 		   in braces: ({, })
	 * 
	 * no error handling: it is assumed that both strings are valid
	 * 
	 * */
	
	public static boolean matches(String str, String pattern) {
		
		int i = 0, j = 0;
		int multiplicator;
		
		while(i < str.length()) {
			
			if(pattern.charAt(j) == '.' || str.charAt(i) == pattern.charAt(j)) {
				
				i++; j++;
				continue;
				
			}
			
			else {
				
				if(pattern.charAt(j) == '{') {
					
					char charMultiplied = pattern.charAt(j-1);
					
					multiplicator = 0; // reset from possible previous value
					
					j++;
					
					while(pattern.charAt(j++) != '}') {
						
						multiplicator *= 10;
						multiplicator += Integer.parseInt("" + pattern.charAt(j-1));
						
					}
					
					/* starts by k=1 as i points at second char after matching char before '{' of the pattern */
					
					for(int k = 1; k < multiplicator; k++) {
						
						if(charMultiplied == '.' || charMultiplied == str.charAt(i)) {
							
							i++;
							continue;
							
						}
						
						else {
							
							return false;
							
						}
						
					}
					
				}
				
				else {
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
}
