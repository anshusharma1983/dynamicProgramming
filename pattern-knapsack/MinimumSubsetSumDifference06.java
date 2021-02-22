import java.util.*;
/*
Same as subset sum
Find the possible subsets for n
if s1 & s2 are 2 sum where s1 + s2 = range
then s2 = range - s1
We have to minimize s2-s1
min(range - s1 - s1) = min(range-s1)
where s1 is the smaller set in s1 & s2, so find all possible subsets, and loop till half to find the minimum subset.
*/
public class MinimumSubsetSumDifference06 {

    public static void main(String[] args) {
        int[] A = {1,2,7};
        int sum = 0;
        for (int e : A) sum += e; 
        int min = helperDP(A, sum);
        System.out.println("min:" + min);
}

    private static int helperDP(int[] A, int sum) {
        int n = A.length;
        boolean[][] dp = new boolean[n+1][sum + 1];
        
        for (int i=0; i<=n; i++) dp[i][0] = true;
        for (int j=1; j<=sum; j++) dp[0][sum] = false;
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                if (j >= A[i-1]) {
                    dp[i][j] = dp[i-1][j-A[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j=0; j<=sum/2; j++) {
            if (dp[n][j]) {
                min = Math.min(min, sum - 2*j);
            }
        }
        return min;
    }
}
