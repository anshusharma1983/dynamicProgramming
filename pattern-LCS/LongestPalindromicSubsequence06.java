
/*
 a: agbcba
 O: 5 // abcba
    = LCS(a, a.reverse())
 */
public class LongestPalindromicSubsequence06 {
    public static void main(String[] args) {
        String a = "agbcba";
        String b = new StringBuilder(a).reverse().toString();
        int lcps = LongestCommonSubsequence01.lcs(a, b, a.length(), b.length());
        System.out.println(lcps);
    }
}
