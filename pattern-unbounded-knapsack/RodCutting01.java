import java.util.*;

public class RodCutting01 {

 public static void main(String[] args) {
     int[] length = {1,2,3,4,5,6,7,8};
     int[] price = {1,5,8,9,10,17,18,20};
     int K = 8;
     int P2 = helper(length, price, K, price.length);
     int P3 = helper2(length, price, K);
     System.out.println("P2:" +  P2);
     System.out.println("P3:" + P3);
     // O : 22 (6 & 2 i.e. 5 + 17 = 22)
     // divide so that the price is maximized
 }

 private static int helper(int[] length, int[] price, int K, int n) {
    if (n == 0 || K ==0 ) return 0;
    if (length[n-1] <= K) {
        return Math.max(price[n-1] + helper(length, price, K - length[n-1], n), helper(length, price, K, n-1));
    } else {
        return helper(length, price, K, n-1);
    }
 }

 private static int helper2(int[] length, int[] price, int K) {
    int N = price.length;
    int[][] dp = new int[N+1][K+1]; 
    for (int i=0; i<=N; i++) dp[i][0] = 0;
    for (int j=0; j<=K; j++) dp[0][j] = 0;

    for (int i=1; i<=N; i++) {
        for (int j=1; j<=K; j++) {
            if (j >= length[i-1]) {
                dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]); 
            } else {
                dp[i][j] = dp[i-1][j];
            }
        } 
    }
    return dp[N][K];
 }
}