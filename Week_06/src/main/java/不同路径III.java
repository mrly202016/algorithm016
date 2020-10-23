/**
 * 不同路径 III   https://leetcode-cn.com/problems/unique-paths-iii/
 */
public class 不同路径III {
    public int uniquePathsIII(int[][] grid) {//DFS比DP好理解，这里用DFS做
        int startX=0,startY=0,count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    startX=i;
                    startY=j;
                    continue;
                }
                if(grid[i][j]==0) count++;
            }
        }
        return dfs(startX,startY,count+1,grid);
    }

    private int dfs(int i, int j, int restSteps, int[][] grid) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==-1) return 0;
        if(grid[i][j]==2) return restSteps==0?1:0;
        int count=0;
        grid[i][j]=-1;
        count+=dfs(i-1,j,restSteps-1,grid);
        count+=dfs(i+1,j,restSteps-1,grid);
        count+=dfs(i,j-1,restSteps-1,grid);
        count+=dfs(i,j+1,restSteps-1,grid);
        grid[i][j]=0;
        return count;
    }
}
