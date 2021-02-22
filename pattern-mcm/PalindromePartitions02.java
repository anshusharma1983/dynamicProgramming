/**
 S: noonabbad
 O: 2
 S: nitik
 O: 2
 */

public class PalindromePartitions02 {

    public static void main(String[] args) {
        String s = "nitik";
        int res = solve(s, 0, s.length() - 1);
        System.out.println(res);
    }

    static int solve(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        int res = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            int cuts = 1 + solve(s, i, k) + solve(s, k+1, j);
            res = Math.min(res, cuts);
        }
        return res;
    }

	private static boolean isPalindrome(String s, int i, int j) {
        if (i > j) return false;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
	}
}
