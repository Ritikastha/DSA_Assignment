package Assignment_Question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Question 7
//        a)	Implement multi-threaded algorithm to multiply n*n matrix.

//public class Q7a {

class Matrix_Multiplier {
//    Create a thread pool with a set number of threads equal to the number of processors available on the machine.
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] resultMatrix;

//    Constrructor
    public Matrix_Multiplier(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = new int[matrix1.length][matrix2[0].length];
    }

    public int[][] multiply() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                executor.execute(new Cell_Multiplier(i, j));
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }

//    is responsible of adding the appropriate row from the first matrix to the appropriate column from
//    the second matrix and saving the outcome in the resulting matrix.
    private class Cell_Multiplier implements Runnable {
        private final int row;
        private final int col;

        public Cell_Multiplier(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void run() {
//            iterate through each cell in the resulting matrix
            for (int i = 0; i < matrix2.length; i++) {
                resultMatrix[row][col] += matrix1[row][i] * matrix2[i][col];
            }
        }
    }

    public static void main(String[] args) {
//        create two matrices matrix1 and matrix2 to be multiplied
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };

        int[][] matrix2 = {
                {5, 6},
                {7, 8}
        };
//        create an instance
        Matrix_Multiplier multiplier = new Matrix_Multiplier(matrix1, matrix2);
//        call multiply  method to obtain the resulting matrix
        int[][] result = multiplier.multiply();
//        Print the resulting matrix for verification
        System.out.println("Result matrix:");
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

