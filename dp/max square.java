class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return 0; 
        }
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row+1][col+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    // dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1;
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > max) {
                       max = dp[i][j]; 
                    }
                }
            }
        }
        return max*max;
    }
}