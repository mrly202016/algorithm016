import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后  https://leetcode-cn.com/problems/n-queens/description/
 */
public class N皇后二刷 {
    public List<List<String>> solveNQueens_bit(int n) {
        List<List<String>> lists=new ArrayList<>();
        int[] idx=new int[n];
        dfs_bit(0,n,0,0,0,idx,lists);
        return lists;
    }

    private void dfs_bit(int depth, int n, int col, int main, int sub, int[] idx, List<List<String>> lists) {
        if(depth==n){
            lists.add(generate(idx));
            return;
        }

        int available=((1<<n)-1) & ~(col|main|sub);//获取当前能摆放的所有位置
        while(available!=0){
            int rightest=available & -available;//获取最右边的1
            idx[depth]=Integer.bitCount(rightest-1);//获取当前1所在位
            //对角线的合并移动可以参看N皇后II的解释
            dfs_bit(depth+1,n,col|rightest,(main|rightest)<<1,(sub|rightest)>>1,idx,lists);//当前位置左右移动即是下一行对角线位置
            idx[depth]=0;
            available&=available-1;//最右边的1清零
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists=new ArrayList<>();
        boolean[] col=new boolean[n];
        boolean[] main=new boolean[2*n-1];// /
        boolean[] sub=new boolean[2*n-1];// \
        int[] idx=new int[n];
        dfs(0,n,col,main,sub,idx,lists);
        return lists;
    }

    private void dfs(int depth, int n, boolean[] col, boolean[] main, boolean[] sub, int[] idx, List<List<String>> lists) {
        if(depth==n){
            lists.add(generate(idx));
            return;
        }

        for(int j=0;j<n;j++){
            if(col[j]||main[depth+j]||sub[depth-j+n-1]) continue;
            idx[depth]=j;
            col[j]=true;
            main[depth+j]=true;
            sub[depth-j+n-1]=true;
            dfs(depth+1,n,col,main,sub,idx,lists);
            idx[depth]=0;
            col[j]=false;
            main[depth+j]=false;
            sub[depth-j+n-1]=false;
        }
    }

    private List<String> generate(int[] idx) {
        List<String> list=new ArrayList<>();
        char[] chars=new char[idx.length];
        Arrays.fill(chars,'.');
        for(int i=0;i<idx.length;i++){
            chars[idx[i]]='Q';
            list.add(new String(chars));
            chars[idx[i]]='.';
        }
        return list;
    }
}
