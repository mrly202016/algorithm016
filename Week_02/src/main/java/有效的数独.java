import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode做题-有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 */
public class 有效的数独 {
    public boolean isValidSudokuSet(char[][] board) {
        Set set=new HashSet();
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                //第5行的6标记为  (6)5
                //第5列的6标记为  6(5)
                //第5个box标记为  1(5)1
                if(board[i][j]!='.'){
                    if(!(set.add("("+board[i][j]+")"+i)&&set.add(j+"("+board[i][j]+")")&&set.add(i/3+"("+board[i][j]+")"+j/3))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuMap(char[][] board) {
        Map<Integer,Integer>[] rows=new HashMap[9];
        Map<Integer,Integer>[] cols=new HashMap[9];
        Map<Integer,Integer>[] box=new HashMap[9];

        for(int i=0;i<9;i++){
            rows[i]=new HashMap<>();
            cols[i]=new HashMap<>();
            box[i]=new HashMap<>();
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j];
                    rows[i].put(num,rows[i].getOrDefault(num,0)+1);
                    cols[j].put(num,cols[j].getOrDefault(num,0)+1);
                    int index=(i/3*3)+j/3;//这个计算很巧妙
                    box[index].put(num,box[index].getOrDefault(num,0)+1);

                    if(rows[i].get(num)>1||cols[j].get(num)>1||box[index].get(num)>1){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
