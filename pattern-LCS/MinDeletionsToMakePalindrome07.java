/**
 a  : AGBCBA
 O: 1

 a.length - LCPS (06)

 */
public class MinDeletionsToMakePalindrome07 {
    public static void main(String[] args) {
        String a = "agbcba";
        String b = new StringBuilder(a).reverse().toString();
        int lcps = LongestCommonSubsequence01.lcs(a, b, a.length(), b.length());
        System.out.println(a.length() - lcps);        
    }
}
