import java.util.*;
/*
 int[] A = { 1,5, 11, 5}
  O: true // 1+5+5, 11
  This is same as SubsetSum partition problem 
*/

public class EqualSumPartition03 {
    public static void main(String[] args) {
        int[] A = {1, 5, 11, 5};
        System.out.println(helperDP(A));
    }

    private static boolean helperDP(int[] A) {
        int sum = 0;
        for (int e : A) sum += e; 
        if (sum % 2 != 0) return false;
        int rem = sum / 2;
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