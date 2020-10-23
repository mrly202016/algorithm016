import java.util.Arrays;

/**
 * 最小路径和  https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class 最小路径和 {
    public static void main(String[] args) {
        最小路径和 t=new 最小路径和();
        System.out.println(t.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(t.minPathSum2(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public int minPathSum2(int[][] grid) {//空间优化
        int m=grid.length;
        int n=grid[0].length;
        if(m==0||n==0) return 0;
        int[] cur=new int[n];
        cur[n-1]=grid[m-1][n-1];
        for(int j=n-2;j>=0;j--) cur[j]+=cur[j+1]+grid[m-1][j];
        for(int i=m-2;i>=0;i--){
            cur[n-1]+=grid[i][n-1];
            for(int j=n-2;j>=0;j--){
                cur[j]=Math.min(cur[j+1],cur[j])+grid[i][j];
            }
        }
        return cur[0];
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m==0||n==0) return 0;
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=grid[m-1][n-1];
        for(int i=m-2;i>=0;i--) dp[i][n-1]+=dp[i+1][n-1]+grid[i][n-1];
        for(int j=n-2;j>=0;j--) dp[m-1][j]+=dp[m-1][j+1]+grid[m-1][j];
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j];
            }
        }
        return dp[0][0];
    }
}
