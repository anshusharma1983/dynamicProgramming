import java.util.*;
/**
 Find number of ways in which an expression can be evaluated to true
 s: T&F|T
 (T&F)|T = F|T = T
 T&(F|T) = T&T = T
 o: 2
 s; T&F^T
 o: 2 
 (T&F)^T = F^T = T 
 (T&(F^T)) T&T
  */
public class WaysExpressionEvaluateTrue03 {
    public static void main(String[] args) {
        String[] S = {"T&F|T", "T&F^T", "T&T&F|T"};
        for (String s : S) {
            System.out.println("EVALUATING: "+ s);
            Map<String, Integer> memo = new HashMap<>();
            int ways = ways(s.toCharArray(), 0, s.length()-1, true, memo);
            System.out.println("WAYS:" + s + ":" + ways);
        }
    }

    private static int ways(char[] s, int i, int j, boolean boolExp, Map<String, Integer> memo) {
        String key = i + ":" + j + ":" + boolExp;
        if(memo.containsKey(key)) 
            return memo.get(key);
        System.out.println("[i:j] : [ " + i + ":" + j + "], bool:" + boolExp);
        if (i > j) 
            return 0;
        if (i == j) {
            System.out.println("bool:" + boolExp + ",s[i]:" + s[i]);
            if (boolExp & s[i] == 'T' || !boolExp && s[i] == 'F') 
                return 1;
            else 
                return 0;
        }
        int ans = 0;
        for (int k=i+1; k<j; k+=2) {
            char op = s[k];
            System.out.println("OP:" + op + ",[i, j]:[" + i + ":" + j + "], k:" + k);
            int leftTrue = ways(s, i, k-1, true, memo);
            int leftFalse = ways(s, i, k-1, false, memo);
            int rightTrue = ways(s, k+1, j, true, memo);
            int rightFalse = ways(s, k+1, j, false, memo);
            System.out.println("LT:" + leftTrue + ",LF:" + leftFalse + ",RT:" + rightTrue + ",RF:" + rightFalse);
            switch(op) {
                case '&':
                    if (boolExp) {
                        ans += leftTrue * rightTrue;
                    } else {
                        ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    }
                break;
                case '|':
                    if (boolExp) {
                        ans += leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                    } else {
                        ans += leftFalse * rightFalse;
                    }
                break;
                case '^':
                    if (boolExp) {
                        ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    } else {
                        ans += leftTrue * rightTrue + leftFalse * rightFalse;
                    }
                break;
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
