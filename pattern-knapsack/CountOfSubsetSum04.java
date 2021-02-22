public class CountOfSubsetSum04 {
    public static void main(String[] args) {
        int[] A = {2, 3, 5,6, 8, 10};
        int k = 10;
        // output should be 2 i.e. 8+2, 10
        for (int i=0; i<20; i++) {
            int count = helper(A, A.length, i);
            int count2 = helperDP(A, i);
            System.out.println("i:" + i + ",count  :" + count);
            System.out.println("i:" + i + ",count2 :" + count2 + "\n");
        }
    }

    private static int helper(int[] A, int i, int rem) {
        if (rem == 0) return 1;
        if (i == 0) return 0;
        if (rem >= A[i-1]) {
            return helper(A, i-1, rem - A[i-1]) + helper(A, i-1, rem);
        } else {
            return helper(A, i-1, rem);
        }
    }

    private static int helperDP(int[] A, int rem) {
        int n = A.length;
        int[][] dp = new int[n+1][rem + 1];
        
        for (int i=0; i<=n; i++) dp[i][0] = 1;
        for (int j=1; j<=rem; j++) dp[0][rem] = 0;
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=rem; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i-1][j-A[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rem];
    }
}
