import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode做题-岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 */
public class 岛屿数量 {
    public int numIslands_BFS(char[][] grid) {//广度优先遍历，遍历过的位置改成0就是去重
        if(grid==null||grid.length==0){
            return 0;
        }

        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j]='0';
                    //给每个格子编号，从左到右，从上到下
                    //0，1，2
                    //3，4，5
                    //6，7，8
                    queue.offer(i*col+j);
                    while (!queue.isEmpty()){
                        int position=queue.poll();
                        int row_pos = position / col;
                        int col_pos = position % col;
                        //当前格子上下左右都看看是不是1，是1就加进来，然后再改成0，代表遍历过
                        if(row_pos-1>=0&&grid[row_pos-1][col_pos]=='1'){
                            queue.offer((row_pos-1)*col+col_pos);
                            grid[row_pos-1][col_pos] = '0';
                        }
                        if(row_pos+1<row&&grid[row_pos+1][col_pos]=='1'){
                            queue.offer((row_pos+1)*col+col_pos);
                            grid[row_pos+1][col_pos] = '0';
                        }
                        if(col_pos-1>=0&&grid[row_pos][col_pos-1]=='1'){
                            queue.offer(row_pos*col+col_pos-1);
                            grid[row_pos][col_pos-1] = '0';
                        }
                        if(col_pos+1<col&&grid[row_pos][col_pos+1]=='1'){
                            queue.offer(row_pos*col+col_pos+1);
                            grid[row_pos][col_pos+1] = '0';
                        }
                    }
                }
            }
        }

        return count;
    }

    public int numIslands_DFS(char[][] grid) {//深度优先遍历，遍历过的位置改成0就是去重
        if(grid==null||grid.length==0){
            return 0;
        }

        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row=grid.length;
        int col=grid[0].length;

        if(i<0||j<0||i>=row||j>=col||grid[i][j]=='0'){
            return;
        }

        //上下左右遍历，将遇到的1都改成0，代表遍历过
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
