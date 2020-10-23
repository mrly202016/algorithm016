/**
 * 回文子串  https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class 回文子串 {
    public int countSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int count=0;
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }
}
