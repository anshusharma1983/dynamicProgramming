import java.util.*;
/*
 int[] A = { 2, 3, 7, 8 , 10}
 k = 11
 O: true // 3 + 8
*/
public class SubsetSum02 {
    public static void main(String[] args) {
        int[] A = {2, 3, 7, 8, 10};
        int k = 11;
        for (int i=0; i<20; i++) {
            boolean isSum = helper(A, A.length, i);
            boolean isSum2 = helperDP(A, i);
            System.out.println("i:" + i + ", o:" + isSum + ":"+ isSum2);
        }
    }

    private static boolean helper(int[] A, int i, int rem) {
        if (rem == 0) return true;
        if (i == 0) return false;
        if (rem >= A[i-1]) {
            return helper(A, i-1, rem - A[i-1]) || helper(A, i-1, rem);
        } else {
            return helper(A, i-1, rem);
        }
    }

    private static boolean helperDP(int[] A, int rem) {
        int n = A.length;
        boolean[][] dp = new boolean[n+1][rem + 1];
        
        for (int i=0; i<=n; i++) dp[i][0] = true;
        for (int j=1; j<=rem; j++) dp[0][rem] = false;
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=rem; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i-1][j-A[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rem];
    }
}