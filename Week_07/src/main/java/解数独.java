import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 解数独  https://leetcode-cn.com/problems/sudoku-solver/#/description
 */
public class 解数独 {
    public static void main(String[] args) {
        解数独 t=new 解数独();
        char[][] chars=new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        t.solveSudoku3(chars);
        for(char[] ch:chars){
            System.out.println(Arrays.toString(ch));
        }
    }

    Set<Character>[] rowSet=new Set[9];
    Set<Character>[] colSet=new Set[9];
    Set<Character>[] boxSet=new Set[9];

    public void solveSudoku3(char[][] board) {
        for(int i=0;i<9;i++){
            rowSet[i]=new HashSet<>();
            colSet[i]=new HashSet<>();
            boxSet[i]=new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    boxSet[i/3*3+j/3].add(board[i][j]);
                }
            }
        }

        backTrack(board,0,0);
    }

    private boolean backTrack(char[][] board, int row, int col) {
        if(col==9) return backTrack(board,row+1,0);
        if(row==9) return true;
        if(board[row][col]!='.') return backTrack(board,row,col+1);
        for(char c='1';c<='9';c++){
            if(isValid(row,col,c)){
                board[row][col]=c;
                if(backTrack(board,row,col+1)) return true;
                rowSet[row].remove(c);
                colSet[col].remove(c);
                boxSet[row/3*3+col/3].remove(c);
                board[row][col]='.';
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, char c) {
        if(!rowSet[row].add(c)) return false;
        if(!colSet[col].add(c)){
            rowSet[row].remove(c);
            return false;
        }
        if(!boxSet[row/3*3+col/3].add(c)){
            rowSet[row].remove(c);
            colSet[col].remove(c);
            return false;
        }
        return true;
    }

    public void solveSudoku2(char[][] board) {
        dfs(board,0,0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if(col==9) return dfs(board,row+1,0);
        if(row==9) return true;
        if(board[row][col]!='.') return dfs(board,row,col+1);
        for(char c='1';c<='9';c++){
            if(isValid(board,row,col,c)){
                board[row][col]=c;
                if(dfs(board,row,col+1)) return true;
                board[row][col]='.';
            }
        }
        return false;
    }


    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(dfs(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int k=0;k<9;k++){
            if(board[row][k]==c) return false;
            if(board[k][col]==c) return false;
            if(board[row/3*3+k/3][col/3*3+k%3]==c) return false;
        }
        return true;
    }

}
