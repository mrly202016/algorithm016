import java.util.LinkedList;
import java.util.Queue;

/**
 * 扫雷游戏  https://leetcode-cn.com/problems/minesweeper/
 */
public class 扫雷游戏 {
    public char[][] updateBoard_BFS(char[][] board, int[] click) {
        int i=click[0];
        int j=click[1];
        if(board[i][j]=='M'){
            board[i][j]='X';
            return board;
        }
        int[] dr={-1,1,0,0,-1,-1,1,1};
        int[] dc={0,0,-1,1,-1,1,-1,1};
        int colLen=board[0].length;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i*colLen+j);
        bfs(colLen,queue,board,dr,dc);
        return board;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int i=click[0];
        int j=click[1];
        if(board[i][j]=='M'){
            board[i][j]='X';
            return board;
        }
        int[] dr={-1,1,0,0,-1,-1,1,1};
        int[] dc={0,0,-1,1,-1,1,-1,1};
        dfs(i,j,board,dr,dc);
        return board;
    }

    private void bfs(int colLen, Queue<Integer> queue, char[][] board, int[] dr, int[] dc) {
//        boolean[][] visited=new boolean[board.length][colLen];
        while (!queue.isEmpty()){
            Integer combine=queue.poll();
            int i=combine/colLen;
            int j=combine%colLen;
            int count=0;
            for (int k=0;k<8;k++){
                int tr=i+dr[k];
                int tc=j+dc[k];

                if(tr<0||tr>=board.length||tc<0||tc>=colLen){
                    continue;
                }

                if(board[tr][tc]=='M'){
                    count++;
                }
            }

            if(count>0){
                board[i][j]= (char) (count+'0');
            }else {
                board[i][j]='B';
                for (int k=0;k<8;k++){
                    int tr=i+dr[k];
                    int tc=j+dc[k];

                    if(tr<0||tr>=board.length||tc<0||tc>=colLen){
                        continue;
                    }

                    if(board[tr][tc]=='E'){
                        queue.offer(tr*colLen+tc);
                        board[tr][tc]='B';//这个很妙
                    }
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, int[] dr, int[] dc) {
        int count=0;
        for(int k=0;k<dr.length;k++){
            int tr=i+dr[k];
            int tc=j+dc[k];
            if(tr<0||tr>=board.length||tc<0||tc>=board[0].length){
                continue;
            }
            if(board[tr][tc]=='M'){
                count++;
            }
        }
        if(count>0){
            board[i][j]= (char) (count+'0');
        }else {
            board[i][j]='B';
            for(int k=0;k<dr.length;k++){
                int tr=i+dr[k];
                int tc=j+dc[k];
                if(tr<0||tr>=board.length||tc<0||tc>=board[0].length||board[tr][tc]!='E'){
                    continue;
                }
                dfs(tr,tc,board,dr,dc);
            }
        }
    }
}
