import java.util.Arrays;

/**
 * 被围绕的区域
 */
public class 被围绕的区域 {
    public static void main(String[] args) {
        被围绕的区域 t=new 被围绕的区域();
//        t.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        t.solve(new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}});
    }

    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    if(board[i][j]=='O'){
                        dfs(board,i,j);
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||board[i][j]=='#') return;
        if(board[i][j]=='O') board[i][j]='#';
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i+1,j);
    }
}
