/*
 * This class calculates the CRC value (cyclic redundancy check) for a string.
 * A CRC value can be used to detect random changes in messages transmitted over
 * somewhat unreliable networks, such as the web (does not help to detect 
 * intentional changes by hackers).
 * 
 * */

public class CRC {
	
	private int poly;
	private int degree;
	
	public CRC(int poly) {
		
		this.poly = poly;
		this.degree = getDegree(poly);
		
	}
	
	
	/* 
	 * Gets the degree of the input integer by using
	 * the bitwise right shift operator.
	 * 
	 * */
	
	private int getDegree(int poly) {
		
		int count = 0;
		
		while(poly > 1) {
			
			poly = poly >> 1;
			count++;
			
		}
		
		return count;
		
	}
	
	
	public int getDegree() {
		
		return this.degree;
		
	}
	
	
	/* 
	 * Translates input string (concatenated chars) into concatenation of 
	 * bits representing the char values. Then, shifts the bits of the 
	 * number to the left by the degree of the stored polynomial. Finally,
	 * a polynomial division is performed, whereby the remainder of the 
	 * division, viewed as a binary number, yields the CRC value.
	 * 
	 * */
	
	public int crcASCIIString(String str) {
		
		
		int bitString = 0;
		
		if(str.length() > 0) {
			
			bitString = getBitString(str);
			
			bitString = bitString << getDegree(this.poly);
			
			return remainderPolynomialDivision(bitString);
			
		}
		else {
			
			return 0;
			
		}
		
	}
	
	
	/* 
	 * Returns an integer that represents a bitwise concatenation of all 
	 * single values for each char in input string. For example, for the 
	 * string "az" the method returns 12538 = 11000011111010, or the 
	 * concatenation of bits representing a = 97 = 1100001,
	 * and z = 122 = 1111010.
	 * 
	 * */
	
	private int getBitString(String str) {
		
		int currentChar, bitString = str.charAt(0);
		
		for(int i = 1; i < str.length(); i++) {
			
			currentChar = str.charAt(i);
			
			bitString = bitString << (getDegree(currentChar) + 1);
			
			bitString += currentChar;
			
		}

		return bitString;
		
	}
	
	
	/* 
	 * Calculates the remainder of the polynomial division that is left after
	 * dividing the input string by the specified polynomial.
	 * 
	 * */
	
	private int remainderPolynomialDivision(int bitString) {
		
		/* 
		 * Fills polynomial with 0s from the right to fit input integer's length.
		 * 
		 * */
		
		int posLeft = getDegree(bitString) - this.degree;
				
		int divider = this.poly << posLeft;

		
		/* 
		 * Starts polynomial division from left, changing only the first n-bits, 
		 * where n equals the degree of the polynomial. The rest on the right
		 * remains the same, therefore it fills up the divider with as many 0s
		 * as needed. Stop when the degree of the remaining rest is smaller than
		 * the degree of the polynomial.
		 * 
		 * */
		
		int remainder = bitString ^ divider;
		
		while(getDegree(remainder) >= this.degree) {
			
			posLeft = getDegree(remainder) - this.degree;
			
			divider = this.poly << posLeft;			
			
			remainder ^= divider;
			
		}
		
		return remainder;
		
	}
	
}
