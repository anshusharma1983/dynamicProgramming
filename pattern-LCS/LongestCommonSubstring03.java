
public class LongestCommonSubstring03 {
    private static int res = Integer.MIN_VALUE; 
    public static void main(String args[]) {
        String a = "abcdgh";
        String b = "abedghfhr";
        System.out.println("dp: " + dp(a, b));
    }
    
    private static int dp(String a, String b) {
        int A = a.length();
        int B = b.length();
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[A+1][B+1];
        for (int i=0; i<=A; i++) 
            dp[i][0] = 0;
        for (int j=0; j<=B; j++) 
            dp[0][j] = 0;

        for (int i=1; i<=A; i++) {
            for (int j=1; j<=B; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }
}
