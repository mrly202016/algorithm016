import java.util.*;

/**
 * N 皇后  https://leetcode-cn.com/problems/n-queens/
 */
public class N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists=new ArrayList<>();
        boolean[] col=new boolean[n];
        boolean[] main=new boolean[2*n-1];
        boolean[] sub=new boolean[2*n-1];
        LinkedList<Integer> path=new LinkedList<>();
        dfs(n,0,col,main,sub,path,lists);
        return lists;
    }

    private void dfs(int n,int depth, boolean[] col, boolean[] main, boolean[] sub, LinkedList<Integer> path, List<List<String>> lists) {
        if(depth==n){
            lists.add(generate(path,n));
            return;
        }
        for(int i=0;i<n;i++){
            //主对角线"\"：row-col=固定值
            //副对角线"/"：row+col=固定值
            if(col[i]||main[depth-i+n-1]||sub[depth+i]){
                continue;
            }
            path.addLast(i);
            col[i]=true;
            main[depth-i+n-1]=true;
            sub[depth+i]=true;
            dfs(n,depth+1,col,main,sub,path,lists);
            col[i]=false;
            main[depth-i+n-1]=false;
            sub[depth+i]=false;
            path.removeLast();
        }

    }

    private List<String> generate(LinkedList<Integer> path, int n) {
        List<String> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            char[] chars=new char[n];
            Arrays.fill(chars,'.');
            chars[path.get(i)]='Q';
            list.add(new String(chars));
        }
        return list;
    }
}
