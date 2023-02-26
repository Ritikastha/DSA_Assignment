package Assignment_Question;

/*Question 8
a)
Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s.
INPUT: 1 0 1 0 0
0 1 1 1 1
0 0 0 0 1
0 0 0 1 1
0 1 0 1 1
OUTPUT: 4
*/

class Max_Area_Of_0 {
    public static int Max(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // create a 2D array to store the maximum square area for each position in the matrix
        int[][] dp = new int[n][m];
        // initialize
        int maxArea = 0;

        // loop through each position in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if the current position contains a 0
                if (matrix[i][j] == 0) {
                    // initialize the maximum square area for this position to 1
                    dp[i][j] = 1;
                    // update the maximum area to 1
                    maxArea = 1;
                }
            }
        }

        // loop through each position in the matrix (starting from the second row and second column)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
//                check if it is equals to 0
                if (matrix[i][j] == 0) {
                    // calculate the maximum square area that can be formed at this position
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    // update the maximum area if necessary
                    maxArea = Math.max(maxArea, dp[i][j]);
                }
            }
        }
//Return
        return maxArea * maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        int maxArea = Max(matrix);
        System.out.println("Maximum area of square made by 0s: " + maxArea);
    }

}
