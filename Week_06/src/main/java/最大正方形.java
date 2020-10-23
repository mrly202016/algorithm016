import java.util.Arrays;

/**
 * 最大正方形  https://leetcode-cn.com/problems/maximal-square/
 */
public class 最大正方形 {
    public static void main(String[] args) {
        最大正方形 t=new 最大正方形();
        System.out.println(t.maximalSquare(new char[][]{{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','0','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'}}));
        System.out.println(t.maximalSquare2(new char[][]{{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','0','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'}}));
    }

    public int maximalSquare2(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[] cur=new int[matrix[0].length+1];
        int max=0;
        int temp=0;
        for(int i=1;i<matrix.length+1;i++){
            int last=0;
            for(int j=1;j<cur.length;j++){
                if(matrix[i-1][j-1]=='1'){
                    temp=cur[j];
                    cur[j]=Math.min(last,Math.min(cur[j-1],cur[j]))+1;
                    max=Math.max(max,cur[j]*cur[j]);
                    last=temp;
                }else {
                    cur[j]=0;
                }
            }
        }
        return max;
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        int max=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    max=Math.max(max,dp[i][j]*dp[i][j]);
                }
            }
        }
        return max;
    }
}
