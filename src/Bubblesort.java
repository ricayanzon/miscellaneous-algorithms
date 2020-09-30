/*
 * BubbleSort: Repeatedly run through the array from left to right
 * and swap two adjacent array elements each time, if element at 
 * position i is larger than element at position i+1. This process 
 * is repeated iteratively as long as there are changes in an 
 * iteration. After an entire iteration without any changes, the 
 * array is sorted in ascending order.
 * 
 * */

public class Bubblesort {

	public static void main(String[] args) {
		
		/* ----------- Test ----------- */
		
		int[] a = {1,3,5,7,9,8,6,4,2,0,-1};
		int[] b = {5,3,7,3,2,8,6,9,4,4,2,3};
		int[] c = {};
		int[] d = {1};
		int[] e = null;
				
		bubbleSort(a);
		System.out.println("Filtered array: " + java.util.Arrays.toString(filter(a)) + "\n");
		
		bubbleSort(b);		
		System.out.println("Filtered array: " + java.util.Arrays.toString(filter(b)) + "\n");
		
		bubbleSort(c);		
		System.out.println("Filtered array: " + java.util.Arrays.toString(filter(c)) + "\n");
		
		bubbleSort(d);			
		System.out.println("Filtered array: " + java.util.Arrays.toString(filter(d)) + "\n");
		
		bubbleSort(e);		
		System.out.println("Filtered array: " + java.util.Arrays.toString(filter(e)) + "\n");
		
		/* --------- End Test --------- */

	}
	
	/*
	 * Sorts the array that is located at the position to which 
	 * the passed reference points. Prints the array before and
	 * after sorting the contained elements.
	 * 
	 * */
	
	public static void bubbleSort(int[] ar) {
		
		if(ar == null) {

			System.out.println("Input array:    null");
			System.out.println("Sorted array:   null");
			return;
			
		}

		System.out.println("Input array:    " + java.util.Arrays.toString(ar));
		
		/* 
		 * Actual BubbleSort algorithm.
		 * 
		 * */
		
		boolean swapped = true;
		
		while(swapped) {
			
			swapped = false;
			
			for(int i = 0; i < ar.length-1; i++) {
				
				if(ar[i] > ar[i+1]) {
					
					swap(ar, i, i+1);
					swapped = true;
					
				}
				
			}
			
		}
		
		System.out.println("Sorted array:   " + java.util.Arrays.toString(ar));
		
	}
	
	
	/*
	 * Swaps values in positions pos1 and pos2 of the passed array.
	 * 
	 * */
	
	private static void swap(int[] ar, int pos1, int pos2) {
		
		int tmp = ar[pos1];
		
		ar[pos1] = ar[pos2];
		ar[pos2] = tmp;
		
	}
	
	
	/* 
	 * Returns a reference to a copy of data in which each value occurs 
	 * at most once. It is assumed that input array is already sorted.
	 * 
	 * */
	
	public static int[] filter(int[] data) {
		
		if(data == null) return null;
		if(data.length < 2) return data;
		
		int countRep = 0;
		
		for(int i = 0; i < data.length-1; i++) {
			
			if(data[i] == data[i+1]) {
				
				countRep++;
				
			}
			
		}
		
		int[] filteredData = new int[data.length - countRep];
		int nextPos = 0;
		
		for(int j = 0; j < data.length-1; j++) {
			
			if(data[j] != data[j+1]) {
				
				filteredData[nextPos++] = data[j];
				
				if(j == data.length-2) {
					
					filteredData[nextPos] = data[j+1];
					
				}
				
			}
			
		}
		
		return filteredData;
		
	}

}
