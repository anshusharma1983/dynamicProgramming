import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {
    int[] Wt = {1, 2, 3, 5, 7};
    int[] V = {1, 4, 5, 7, 10};
    int C = 7;
    int memo = memoHelper(Wt, V, C);
    int dp = getProfitDP(Wt, V, C);
    for (int c = 0; c < 10; c++) {
        System.out.println("c:" + c + ", memo:" + memoHelper(Wt, V, c));
        System.out.println("c:" + c + ", dp:" + getProfitDP(Wt, V, c));
        System.out.println();
    }
}

private static int getProfitMemo(int[] Wt, int[] V, int C, int n, int[][] dp) {
    if (C == 0 || n == 0) return 0;
    if (dp[C][n] != -1) return dp[C][n];
    if (C >= Wt[n - 1]) {
        dp[C][n] = Math.max(V[n - 1] + getProfitMemo(Wt, V, C - Wt[n - 1], n - 1, dp), getProfitMemo(Wt, V, C, n - 1, dp));
    } else {
        dp[C][n] = getProfitMemo(Wt, V, C, n - 1, dp);
    }
    return dp[C][n];
}
private static int getProfitDP(int[] Wt, int[] V, int W) {
    int n = Wt.length;
    int[][] dp = new int[n + 1][W + 1];
    for (int c = 0; c <= W; c++) dp[0][c] = 0;
    for (int i = 0; i <= n; i++) dp[i][0] = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= W; j++) {
            if (Wt[i - 1] <= j) {
                dp[i][j] = Math.max(V[i - 1] + dp[i - 1][j - Wt[i - 1]], dp[i - 1][j]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[n][W];
}

private static int memoHelper(int[] wt, int[] v, int C) {
    int[][] dp = new int[C + 1][wt.length + 1];
    for (int[] row : dp)
        Arrays.fill(row, -1);
    return getProfitMemo(wt, v, C, wt.length, dp);
}

}