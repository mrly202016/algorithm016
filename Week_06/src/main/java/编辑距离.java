import java.util.Arrays;

/**
 * 编辑距离  https://leetcode-cn.com/problems/edit-distance/
 */
public class 编辑距离 {
    public static void main(String[] args) {
        编辑距离 t=new 编辑距离();
        System.out.println(t.minDistance("intention","execution"));
        System.out.println(t.minDistance2("intention","execution"));
    }

    public int minDistance2(String word1, String word2) {//空间优化
        int[] cur=new int[word2.length()+1];
        for(int j=1;j<cur.length;j++) cur[j]=j;
        int temp=0;
        for(int i=1;i<word1.length()+1;i++) {
            cur[0]=i;
            int last=i-1;
            for (int j=1;j<cur.length;j++) {
                temp=cur[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cur[j]=last;
                }else {
                    cur[j]=Math.min(cur[j-1],Math.min(cur[j],last))+1;
                }
                last=temp;
            }
        }
        return cur[cur.length-1];
    }

    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<dp.length;i++) dp[i][0]=i;
        for(int j=1;j<dp[0].length;j++) dp[0][j]=j;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //从2个单词末尾开始比较，分相同和不相同的情况讨论，然后采用递归，即自顶向下的思维去推导出状态转移方程
                //但是实际写程序的时候使用自底向上的方式，即loop，使得程序性能更高
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
