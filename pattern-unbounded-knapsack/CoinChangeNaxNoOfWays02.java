/*
 coins: 1, 2, 3
 K = 5
 No. of ways in which you can make 5
 O: 5
 i.e. 
 1 * 5 - 5 coins of 1
 1 * 3 + 2
 1 + 2 * 3
 2 + 3
 5 * 1
*/
public class CoinChangeNaxNoOfWays02 {

    public static void main(String args[]) {
        int[] coins = {1, 2, 3};
        int K = 5;
        int ways = helper(coins, K, coins.length);
        System.out.println("ways: " + ways);
        System.out.println("dp :" + dp(coins, K));
    }

    private static int helper(int[] coins, int K, int n) {
        if (K == 0) return 1;
        if (n == 0) return 0;
        if (coins[n-1] <= K) {
            return helper(coins, K-coins[n-1], n) + helper(coins, K, n-1);
        } else {
            return helper(coins, K, n-1);
        }
    }

    private static int dp(int[] coins, int K) {
        int N = coins.length;
        int[][] dp = new int[N+1][K+1];
        for (int i=0; i<=N; i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<=K; j++) {
            dp[0][j] = 0;
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) { 
                if (j >= coins[i-1]) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]; 
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][K];
    }
}
