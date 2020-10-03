import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量  https://leetcode-cn.com/problems/number-of-islands/
 */
public class 岛屿数量二刷 {
    public int numIslands_BFS(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        Queue<Integer> queue=new LinkedList<>();
        int colLen=grid[0].length;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    count++;
                    queue.offer(i*colLen+j);
                    while (!queue.isEmpty()){
                        int combine=queue.poll();
                        int ti=combine/colLen;
                        int tj=combine%colLen;
                        if(ti+1<grid.length&&grid[ti+1][tj]=='1') {
                            queue.offer((ti+1)*colLen+tj);
                            grid[ti+1][tj]='0';
                        }
                        if(ti-1>=0&&grid[ti-1][tj]=='1') {
                            queue.offer((ti-1)*colLen+tj);
                            grid[ti-1][tj]='0';
                        }
                        if(tj+1<colLen&&grid[ti][tj+1]=='1') {
                            queue.offer(ti*colLen+tj+1);
                            grid[ti][tj+1]='0';
                        }
                        if(tj-1>=0&&grid[ti][tj-1]=='1') {
                            queue.offer(ti*colLen+tj-1);
                            grid[ti][tj-1]='0';
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i>=grid.length||i<0||j>=grid[0].length||j<0||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
