/*
 * Some operations on matrices and vectors.
 * 
 * */

public class MatrixVectorOperations {

	public static void main(String[] args) {
		
		
		/* ---------------- TEST ---------------- */
		
		double[][] matrixA = new double[3][3];
		
		for(int i = 0; i < matrixA.length; i++) {
			
			for(int j = 0; j < matrixA[0].length; j++) {
				
				matrixA[i][j] = i * 3 + j + 1;
				
			}
			
		}
		
		double[] vectorA = {2,1,3};

		System.out.println(java.util.Arrays.toString(multiply(matrixA, vectorA)));
		
		double[][] matrixB = {{1,-1,2},{0,-3,1}};
		
		double[] vectorB = {2,1,0};

		System.out.println(java.util.Arrays.toString(multiply(matrixB, vectorB)));
		
		/* -------------- END TEST -------------- */
		
	}
	
	
	/*
	 * First index addresses the row, second index addresses the column of
	 * the matrix.
	 * 
	 * */
	
	public static double[] multiply(double[][] matrix, double[] vector) {
		
		/* 
		 * number of columns in matrix must equal number of rows in vector 
		 * 
		 * */
		
		if(matrix[0].length != vector.length) return null;
		
		/* 
		 * the length of the result array (vector) derives from the number 
		 * of rows in the given matrix
		 *  
		 *  */
		
		double[] result = new double[matrix.length];
		double sumProducts = 0;
		
		for(int row = 0; row < matrix.length; row++) {
			
			for(int col = 0; col < matrix[0].length; col++) {
				
				sumProducts += matrix[row][col] * vector[col];
				
			}
			
			result[row] = sumProducts;
			sumProducts = 0;
			
		}
		
		
		return result;
		
	}

}
