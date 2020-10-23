/**
 * 最长有效括号  https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        最长有效括号 t=new 最长有效括号();
        System.out.println(t.longestValidParentheses(")()())()()("));
    }

    public int longestValidParentheses(String s) {
        int[] dp=new int[s.length()];
        int max=0;
        int index=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='(') continue;
            if(s.charAt(i-1)=='('){
                dp[i]=(i>=2?dp[i-2]:0)+2;
            }else {
                index=i-dp[i-1]-1;
                if(index>=0&&s.charAt(index)=='('){
                    dp[i]=dp[i-1]+((index-1>=0)?dp[index-1]:0)+2;
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
