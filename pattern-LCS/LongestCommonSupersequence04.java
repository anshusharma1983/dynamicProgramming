/*
 a: AGGTAB
 b: GXTXAYB
 ss: AGGXTXAYB
 the order should be correct 
 ans : a.len + b.len - lcs
 */
public class LongestCommonSupersequence04 {
    
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int lcs = LongestCommonSubsequence01.lcs(a, b, a.length(), b.length());
        System.out.println(a.length() + b.length() - lcs);
    }
}

