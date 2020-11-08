import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 */
public class 有效的数独二刷 {
    public boolean isValidSudoku2(char[][] board) {
        Set<Character>[] row=new Set[9];
        Set<Character>[] col=new Set[9];
        Set<Character>[] box=new Set[9];
        for(int i=0;i<9;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(!row[i].add(board[i][j])) return false;
                    if(!col[j].add(board[i][j])) return false;
                    int row_i=i/3*3+j/3;
                    if(!box[row_i].add(board[i][j])) return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row=new int[9][10];//10是因为数字是1-9
        int[][] col=new int[9][10];
        int[][] box=new int[9][10];
        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    index=board[i][j]-'0';
                    row[i][index]++;
                    if(row[i][index]>1) return false;
                    col[j][index]++;
                    if(col[j][index]>1) return false;
                    int row_i=i/3*3+j/3;
                    box[row_i][index]++;
                    if(box[row_i][index]>1) return false;
                }
            }
        }
        return true;
    }
}
