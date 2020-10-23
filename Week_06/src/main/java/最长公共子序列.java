import java.util.Arrays;

/**
 * 最长公共子序列  https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        最长公共子序列 t=new 最长公共子序列();
        System.out.println(t.longestCommonSubsequence("aae","abcde"));
    }

    public int longestCommonSubsequence2(String text1, String text2) {//优化
        int m=text1.length()+1;
        int n=text2.length()+1;
        int[] cur=new int[n];
        int temp=0;
        for(int i=1;i<m;i++){
            int last=cur[0];//每一行开头上一个都是空字符串位置的0
            for(int j=1;j<n;j++){
                temp=cur[j];//保存前一行当前列的值，后面j+1的时候，这个值就变成列左上角的last
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cur[j]=last+1;
                }else {
                    cur[j]=Math.max(cur[j-1],cur[j]);
                }
                last=temp;
            }
        }
        return cur[n-1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length()+1;//+1是因为如果某个字符串为空，则公共子序列肯定为0
        int n=text2.length()+1;
        int[][] dp=new int[m][n];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
