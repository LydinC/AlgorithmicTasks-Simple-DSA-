import java.util.*;

public class Exercise6 {
    
    public static void main (String args []){
        
        int arraySize = 2;
        int [][] matrix1 = new int[arraySize][arraySize];
        int [][] matrix2 = new int[arraySize][arraySize];
        int [][] matrix3 = new int[arraySize][arraySize];
        
        matrix1 = fillMatrix(matrix1, arraySize);
        matrix2 = fillMatrix(matrix2, arraySize);
        matrix3 = multiplyMatrices(matrix1, matrix2, matrix3, arraySize);
        printMatrix(matrix1, arraySize);
        printMatrix(matrix2, arraySize);
        printMatrix(matrix3, arraySize);
    }
    
    public static int[][] fillMatrix(int[][] matrix, int arraySize)
    {
        Random randomize = new Random();
        for(int i = 0 ; i < arraySize ; i ++){
            for(int j = 0 ; j < arraySize ; j ++){
                matrix[i][j] = randomize.nextInt(100) +1;
            }
        }
        return matrix;
    }
    
    public static int[][]  multiplyMatrices(int[][] mat1, int[][] mat2, int[][] mat3, int arraySize)
    {   
        //multiplication of matrices and storing in matrice 3
        for(int i = 0 ; i < arraySize ; i ++){
            for(int j = 0 ; j < arraySize ; j ++){
                for(int k = 0 ; k < arraySize  ; k++){
                   mat3[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }
        return mat3;
    }
    
    public static void printMatrix(int[][] matrix, int arraySize)
    {           
        System.out.println("Matrix : ");
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.print(matrix[i][j]   +   "\t");
            }
            System.out.println();
        }
    }
}