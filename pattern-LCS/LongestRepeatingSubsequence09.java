/**
 a : AABEBCDD
 o: 3 i.e. ABD

 perform LCS with the same string with a restriction that lcs won't be incremented if i == j

 */
public class LongestRepeatingSubsequence09 {
    public static void main(String[] args) {
        String a = "AABEBCDD";
        String b = new StringBuffer(a).reverse().toString();
        int lrs = lrs(a, b, a.length(), b.length());
        System.out.println(lrs);
    }

    private static int lrs(String a, String b, int m, int n) {
        if (m == 0||n==0) return 0;
        if (a.charAt(m-1) == b.charAt(n-1) && m != n) {
            return 1 + lrs(a, b, m-1, n-1);
        } else {
            return Math.max(lrs(a,b,m,n-1), lrs(a,b,m-1,n));
        }
    }
}
