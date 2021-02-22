/*
 coins: 1, 2, 3
 K = 5
How to make K with min. number of coins
 O: 2 // 2+3
 i.e. 

*/
public class CoinChangeMinNoOfCoins03 {

    public static void main(String args[]) {
        int[] coins = {1, 2, 3};
        int K = 5;
        int noOfCoins = helper(coins, K, coins.length);
        System.out.println("noOfCoins: " + noOfCoins);
        System.out.println("dp :" + dp(coins, K));
    }

    private static int helper(int[] coins, int K, int n) {
        if (K == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE - K;
        if (coins[n-1] <= K) {
            return Math.min(1 + helper(coins, K-coins[n-1], n), helper(coins, K, n-1));
        } else {
            return helper(coins, K, n-1);
        }
    }

    private static int dp(int[] coins, int K) {
        int N = coins.length;
        int[][] dp = new int[N+1][K+1];
        for (int i=0; i<=N; i++) {
            dp[i][0] = 0;
        }
        for (int j=1; j<=K; j++) {
            dp[0][j] = Integer.MAX_VALUE - K;
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) { 
                if (j >= coins[i-1]) {
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]],  dp[i-1][j]); 
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][K];
    }
}
