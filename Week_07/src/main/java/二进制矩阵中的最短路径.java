import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 */
public class 二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix2(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]==1||grid[m-1][n-1]==1) return -1;
        int[] ti=new int[]{-1,-1,0,1,1,1,0,-1};
        int[] tj=new int[]{0,1,1,1,0,-1,-1,-1};
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        int level=0;
        boolean[][] visited=new boolean[m][n];
        while(!queue.isEmpty()){
            level++;
            int size=queue.size();
            while(size>0){
                int[] pos=queue.poll();
                if(pos[0]==m-1&&pos[1]==n-1) return level;
                for(int k=0;k<8;k++){
                    int i=pos[0]+ti[k];
                    int j=pos[1]+tj[k];
                    if(i<0||i>=m||j<0||j>=n||grid[i][j]==1||visited[i][j]) continue;
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
                size--;
            }
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]==1||grid[m-1][n-1]==1) return -1;
        int[] ti=new int[]{-1,-1,0,1,1,1,0,-1};
        int[] tj=new int[]{0,1,1,1,0,-1,-1,-1};
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        int level=0;
        while(!queue.isEmpty()){
            level++;
            int size=queue.size();
            while(size>0){
                int[] pos=queue.poll();
                if(pos[0]==m-1&&pos[1]==n-1) return level;
                for(int k=0;k<8;k++){
                    int i=pos[0]+ti[k];
                    int j=pos[1]+tj[k];
                    if(i<0||i>=m||j<0||j>=n||grid[i][j]==1) continue;
                    queue.offer(new int[]{i,j});
                    grid[i][j]=1;
                }
                size--;
            }
        }
        return -1;
    }
}
