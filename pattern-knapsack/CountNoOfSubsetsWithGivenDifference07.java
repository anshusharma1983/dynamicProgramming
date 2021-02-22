
/*
    sum1 + sum2 = sum
    sum1 - sum2 = diff
    sum1 - (sum - sum1) = diff
    2sum1 - sum = diff
    sum1 = diff + sum / 2
*/


public class CountNoOfSubsetsWithGivenDifference07 {
    public static void main(String[] args) {
        int[] A = {1,1,2,3};
        int diff = 1;
        // O: 3
        int sum = 0;
        for (int e : A) sum += e; 
        int count = helperDP(A, sum, diff);
        System.out.println("count:" + count);
}

    private static int helperDP(int[] A, int sum, int diff) {
        int n = A.length;
        int[][] dp = new int[n+1][sum + 1];
        
        for (int i=0; i<=n; i++) dp[i][0] = 1;
        for (int j=1; j<=sum; j++) dp[0][sum] = 0;
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i-1][j-A[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int count = 0;
        for (int j=0; j<=sum; j++) {
            System.out.println("j:" + j + ":" + dp[n][j]);
            if (j == (diff + sum) / 2) count += dp[n][j];
        }
        return count;
    }
}
