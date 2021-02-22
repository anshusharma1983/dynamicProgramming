import java.util.*;

/**
 Given an array with the dimension of matrics. Find the min. cost to multiply
 A = [ 10 30 5 60 ]
 3 matrices of dimensions
 A: 10 * 30
 B: 30 * 5
 C: 5 * 60
 */
public class MCM01 {
    public static void main(String[] args) {
        // int[] M = {40, 20, 30, 10, 30};
        int[] M = {10, 30, 5, 60};
        int[][] dp = new int[M.length][M.length];
        // int res = solve(M, 1, M.length-1);
        fill(dp, -1);
        int res = solveMemo(M, 1, M.length-1, dp);
        System.out.println(res);
    }

    private static void fill(int[][] dp, int i) {
        for (int[] row : dp) {
            Arrays.fill(row, i);
        }
	}

	static int solveMemo(int[] M, int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            int cost = solveMemo(M, i, k, dp) + solveMemo(M, k+1, j, dp) 
            + M[i-1] * M[k] * M[j];
            res = Math.min(res, cost);
        }
        dp[i][j] = res;
        return res;
    }
    
    static int solve(int[] M, int i, int j) {
        // moving k from i to j-1
        if (i >= j) return 0;
        int res = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            int solve1 = solve(M, i, k);
            int solve2 = solve(M, k+1, j);
            /* Matrix i starts from M[i-1] to [i]
            So multiplication of A(i-1, k) & B(k+1, j) would be M[i-1] * M[k] * M[j]
            */
            int cost = solve1 + solve2 + (M[i-1] * M[k] * M[j]);
            // System.out.println("i:"+i+",j:"+j + ",solve1:"+solve1 +",solve2:"+solve2);
            // System.out.println("solve1 + solve2 + M[i] * M[k] * M[j] : " +cost);
            res = Math.min(res, cost);
        }
        return res;
    }
}