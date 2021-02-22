public class MinAttemptsEggDropping05 {
    public static void main(String[] args) {
        int[][] dp = new int[7][31];
        // System.out.println(solve(30, 6, dp));
        // System.out.println(helperDP(6, 30, dp));
        System.out.println(helper(6, 30, dp));
    }

    private static int solve(int f, int e, int[][] dp) {
        System.out.println(f + ":" + e);
        if (e == 1 || f <= 1) return f;
        if(dp[f][e] > 0)return dp[f][e];
        int res = Integer.MAX_VALUE;
        for (int k=1; k<=f; k++) {
            int cost = 1 + Math.max(solve(k-1, e-1, dp), solve(f-k, e, dp));
            res = Math.min(res, cost);
        }
        dp[f][e] = res;
        return res;
    }

    private static int helperDP(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }
        int min = N;
        for (int i = 1; i <= N; i++) {
            int left = helper(K - 1, i - 1, memo);
            int right = helper(K, N - i, memo);
            min = Math.min(min, Math.max(left, right) + 1);
        }
        memo[K][N] = min;
        return min;
    }

    private static int helper(int K, int N, int[][] dp) {
        System.out.println(N+":"+K);
        if (N <= 1) return N;
        if (K == 1) return N;
        // if (dp[K][N] > 0) return dp[K][N];
        int low=1, high=N, result=N, mid;
        while(low < high) {
            mid = low + (high-low)/2;
            int left = helper(K-1, mid-1, dp);
            int right = helper(K, N-mid, dp);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            }
            if (right > left) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        dp[K][N] = result;
        return result;
    }
}
