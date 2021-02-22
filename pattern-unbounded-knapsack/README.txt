Only difference from normal knapsack is that even after selecting nth value,
 we can still select nth value so we won't consider it taken

Normal knapsack - 
    if (Wt[i - 1] <= j) {
        dp[i][j] = Math.max(V[i - 1] + dp[i - 1][j - Wt[i - 1]], dp[i - 1][j]);
    } else {
        dp[i][j] = dp[i - 1][j];
    }

Unbounded knapsack - 
    if (Wt[i - 1] <= j) {
        dp[i][j] = Math.max(V[i - 1] + dp[i][j - Wt[i - 1]], dp[i - 1][j]);
    } else {
        dp[i][j] = dp[i - 1][j];
    }