import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 滑动谜题  https://leetcode-cn.com/problems/sliding-puzzle/
 */
public class 滑动谜题 {
    public int slidingPuzzle(int[][] board) {
        int[] tr=new int[]{-1,0,1,0};
        int[] tc=new int[]{0,1,0,-1};
        int m=board.length,n=board[0].length;
        char[] chars=new char[m*n];
        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                chars[index++]= (char) (board[i][j]+'0');
            }
        }
        String start=new String(chars);
        String target="123450";
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                String temp=queue.poll();
                if(target.equals(temp)) return level;
                int pos=temp.indexOf('0');
                int row=pos/n,col=pos%n;
                for(int k=0;k<4;k++){
                    int ti=row+tr[k];
                    int tj=col+tc[k];
                    if(ti<0||ti>=m||tj<0||tj>=n) continue;
                    String next=swap(temp,pos,ti*n+tj);
                    if(!visited.add(next)) continue;
                    queue.offer(next);
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    private String swap(String temp, int pos, int i) {
        char[] chars=temp.toCharArray();
        char t=chars[pos];
        chars[pos]=chars[i];
        chars[i]=t;
        return new String(chars);
    }
}
