/*
  a: heap
  b: pea
  O: 3 - insert p, deleat h and p
  ans: a.length() + b.length() - 2 * LCS
 */
public class MinNoOfInsertionsAndDeletions05 {
    public static void main(String[] args) {
        String a= "heap";
        String b = "pea";
        int N = LongestCommonSubsequence01.lcs(a, b, a.length(), b.length());
        System.out.println(a.length() + b.length() - 2 * N);
    }
}

