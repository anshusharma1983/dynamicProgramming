
/*
 X = abcdgh
 Y = abedfhr
 O: 4 i.e. abdh
*/
public class PrintLCS02 {
    public static void main(String args[]) {
        String a = "abcdgh";
        String b = "abedfhr";
        int lcs = lcs(a, b, a.length(), b.length());
        // System.out.println("lcs: " + lcs);
        System.out.println("dp: " + dp(a, b));
    }
    
    private static int lcs(String a, String b, int i, int j) {
        if (i == 0 ||  j == 0) return 0; 
        if (a.charAt(i-1) == b.charAt(j-1)) {
            return 1 + lcs(a, b, i-1, j-1);
        } else {
            return Math.max(lcs(a,b,i-1, j) , lcs(a,b,i,j-1));
        }
    }

    private static int dp(String a, String b) {
        int A = a.length();
        int B = b.length();
        int[][] dp = new int[A+1][B+1];
        for (int i=0; i<=A; i++) 
            dp[i][0] = 0;
        for (int j=0; j<=B; j++) 
            dp[0][j] = 0;

        for (int i=1; i<=A; i++) {
            for (int j=1; j<=B; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        StringBuffer lcs = new StringBuffer();
        print(dp);
        // int prev = dp[A][B];
        // for (int j=B-1; j>=0; j--) {
        //     System.out.println("dp:" + dp[A][j] + ", prev:" + prev + "c:" + b.charAt(j));
        //     if (dp[A][j] != prev) {
        //         lcs = lcs.append(String.valueOf(b.charAt(j)));
        //         prev = dp[A][j];
        //     }
        // }
        int i=A, j = B;
        while (dp[i][j] != 0) {
            if (dp[i-1][j] == dp[i][j-1] && dp[i-1][j-1] < dp[i][j]) {
                lcs.append(a.charAt(i-1)); i--; j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    // lcs.append(a.charAt(i-1)); 
                    i--;
                } else {
                    // lcs.append(b.charAt(j-1)); 
                    j--;
                }
            }
        }
        System.out.println(lcs.reverse().toString());
        return dp[A][B];
    }

    private static void print(int[][] dp) {
        for (int[] row : dp) {
            System.out.println();
            for (int e : row) {
                System.out.print(" " + e);
            }
        }System.out.println();
    }
}