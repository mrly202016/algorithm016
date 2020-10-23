import java.util.Arrays;

/**
 * 不同路径 II  https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class 不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid=new int[3][2];
        obstacleGrid[1][0]=1;
        obstacleGrid[1][1]=1;
        不同路径II t=new 不同路径II();
        System.out.println(t.uniquePathsWithObstacles(obstacleGrid));
        System.out.println(t.uniquePathsWithObstacles2(obstacleGrid));
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[] cur=new int[n];
        cur[n-1]=obstacleGrid[m-1][n-1]==1?0:1;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(obstacleGrid[i][j]==1){
                    cur[j]=0;
                    continue;
                }
                if(j<n-1){
                    cur[j]=cur[j]+cur[j+1];
                }
            }
        }
        return cur[0];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] cells=new int[m][n];
        //因为是从end开始推导，这里要注意个细节，求边界时，也要从右小角开始往左上递推，不然会有问题，不该为1的变成了1，该为0的没有变成0
        for (int i=m-1;i>=0&&obstacleGrid[i][n-1]==0;i--) {//这里遇到一个有障碍物后就退出循环，左上面的就默认为0，即过不来了
            cells[i][n-1]=1;
        }
        for (int j=n-1;j>=0&&obstacleGrid[m-1][j]==0;j--) {
            cells[m-1][j]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]==0){
                    cells[i][j]=cells[i][j+1]+cells[i+1][j];
                }
            }
        }
        return cells[0][0];
    }
}
