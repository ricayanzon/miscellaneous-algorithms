/*
 * Some operations on matrices and vectors.
 * 
 * */

import java.util.Arrays;
import java.lang.Math;

public class MatrixVectorOperations {
	
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
	
	
	public static double cosineSimilarity(double[] v1, double[] v2) {
		
		if(v1.length != v2.length) return -1;

		double scalarpV1V1 = 0;
		double scalarpV1V2 = 0;
		double scalarpV2V2 = 0;
		
		for(int i = 0; i < v1.length; i++) {
			
			scalarpV1V1 += v1[i] * v1[i];
			scalarpV1V2 += v1[i] * v2[i];
			scalarpV2V2 += v2[i] * v2[i];
			
		}
		
		return scalarpV1V2 / Math.sqrt(scalarpV1V1 * scalarpV2V2);
		
	}
	
	
	public static double[][] transpose(double[][] matrix) {
		
		double[][] transposed = new double[matrix[0].length][matrix.length];
		
		for(int row = 0; row < matrix.length; row++) {
			
			for(int col = 0; col < matrix[0].length; col++) {
				
				transposed[col][row] = matrix[row][col];
				
			}
			
		}
		
		return transposed;
	}
	
	
	public static double euclideanDistance(double[] v1, double[] v2) {
		
		if(v1.length != v2.length) return -1;
		
		double sum = 0;
		
		for(int i = 0; i < v1.length; i++) {
			
			sum += Math.pow((v1[i] - v2[i]), 2);
			
		}
		
		return Math.sqrt(sum);
	}
	
	
	
	/***********
	 *         *
	 *  TESTS  *
	 *         *
	 ***********/
	
	
	public static void main(String[] args) {
		
		
		/* ------------------------- TEST MULTIPLY ------------------------- */
		
		
		System.out.println("----------------- MULTIPLY -----------------\n"
				+ "\nMatrix A:           Vector A:     Expected:     Result:");

		double[][] matrixA = new double[3][3];
		
		/*
		 * Initialize matrix a with values from 1 to 9.
		 * 
		 * */
		
		for(int i = 0; i < matrixA.length; i++) {
			
			for(int j = 0; j < matrixA[0].length; j++) {
				
				matrixA[i][j] = i * 3 + j + 1;
				
			}
			
		}
		
		double[] vectorA = {2,1,3};
		double[] expectedA = {13.0, 31.0, 49.0};
		double[] resultA = multiply(matrixA, vectorA);
		
		/*
		 * Visualize matrix A, vector a, expected result and calculated result.
		 * 
		 * */
		
		for(int i = 0; i < matrixA.length; i++) {
			
			System.out.println(Arrays.toString(matrixA[i]) + "     [" + vectorA[i] + "]"
					+ "         [" + expectedA[i] + "]        [" + resultA[i] + "]");

		}
		
		/*
		 * Second test with different matrix, vector, and results.
		 * 
		 * */
		
		double[][] matrixB = {{1,-1,2},{0,-3,1}};
		double[] vectorB = {2,1,0};
		double[] expectedB = {1.0, -3.0};
		double[] resultB = multiply(matrixB, vectorB);

		/*
		 * Visualize matrix B, vector b, expected result and calculated result.
		 * 
		 * */
		
		System.out.println("\nMatrix B:           Vector B:     Expected:     Result:");
	
		String space; // helper for visualization purpose
		
		for(int i = 0; i < matrixB.length; i++) {
			
			space = (i == 0) ? " " : "";
			
			System.out.println(Arrays.toString(matrixB[i]) + "    [" + vectorB[i] + "]"
					+ "         [" + expectedB[i] + "]      " + space + "  [" + resultB[i] + "]");
			
		}
		
		
		
		/* --------------------- TEST COSINE SIMILARITY --------------------- */
		
		
		double[] v1 = {5,0,3,0,2,0,0,2,0,0};
		double[] v2 = {3,0,2,0,1,1,0,1,0,1};
		double[] v3 = {1, 1, 0};
		double[] v4 = {1, 0, 1};
		double cosSimV1V1 = cosineSimilarity(v1, v1);
		double cosSimV1V2 = cosineSimilarity(v1, v2);
		double cosSimV3V4 = cosineSimilarity(v3, v4);
		
		/*
		 * Visualize vectors v1, v2, expected result and calculated result.
		 * 
		 * */

		System.out.println("\n\n------------ COSINE SIMILARITY -------------\n"
				+ "\nVector v1 = " + Arrays.toString(v1)
				+ "\nVector v2 = " + Arrays.toString(v2)
				+ "\nVector v2 = " + Arrays.toString(v3)
				+ "\nVector v2 = " + Arrays.toString(v4)
				+ "\n\nExpected cos(v1,v1) = 1.0,  result: " + cosSimV1V1
				+ "\nExpected cos(v1,v2) ~ 0.94, result: " + cosSimV1V2
				+ "\nExpected cos(v3,v4) = 0.5,  result: " + cosSimV3V4);
		
		
		
		/* ------------------------- TEST TRANSPOSE ------------------------- */
		
		
		double[][] transposedA = transpose(matrixA);
		double[][] transposedB = transpose(matrixB);
		
		/*
		 * Visualize matrix A with A transpose, matrix B with B transpose.
		 * 
		 * */
		
		System.out.println("\n\n---------------- TRANSPOSE -----------------\n\nMatrix A:           A transpose:");
		
		for(int i = 0; i < matrixA.length; i++) {
			
			System.out.println(Arrays.toString(matrixA[i]) + "     " + Arrays.toString(transposedA[i]));
			
		}
		
		System.out.println("\nMatrix B:           B transpose:");
		
		for(int i = 0; i < matrixB.length; i++) {
			
			System.out.println(Arrays.toString(matrixB[i]) + "    " + Arrays.toString(transposedB[i]));
			
			/*
			 * If matrix has less rows than its transpose. For example, 
			 * matrix B has 2 rows while B transpose has 3 rows.
			 * 
			 * */
			
			if(i == matrixB.length-1 && matrixB.length < transposedB.length) {
				
				for(int j = i+1; j < transposedB.length; j++) {
					
					System.out.println("                    " + Arrays.toString(transposedB[j]));
					
				}
				
			}
			
		}
		
		
		
		/* --------------------- TEST EUCLIDEAN DISTANCE --------------------- */
		
		double[] v5 = {1,2,3};
		double[] v6 = {2,4,6};
		double[] v7 = {0,0,0};
		double[] v8 = {-1,-2,-3};
		
		double distV5V6 = euclideanDistance(v5,v6);
		double distV5V7 = euclideanDistance(v5,v7);
		double distV5V8 = euclideanDistance(v5,v8);
		double distV6V5 = euclideanDistance(v6,v5);
		double distV6V7 = euclideanDistance(v6,v7);
		double distV6V8 = euclideanDistance(v6,v8);
		
		System.out.println("\n\n------------ EUCLIDEAN DISTANCE ------------\n"
				+ "\nVector 5: " + Arrays.toString(v5)
				+ "\nVector 6: " + Arrays.toString(v6)
				+ "\nVector 7: " + Arrays.toString(v7)
				+ "\nVector 8: " + Arrays.toString(v8));
		
		System.out.println("\n             Expected:    Result:"
				+ "\nd(v5,v6)  =  3.741657     " + distV5V6
				+ "\nd(v5,v7)  =  3.741657     " + distV5V7
				+ "\nd(v5,v8)  =  7.483315     " + distV5V8
				+ "\nd(v6,v5)  =  3.741657     " + distV6V5
				+ "\nd(v6,v7)  =  7.483315     " + distV6V7
				+ "\nd(v6,v8)  =  11.22497     " + distV6V8);
		
	}

}
