/**
 * N皇后 II   https://leetcode-cn.com/problems/n-queens-ii/description/
 */
public class N皇后II {
    public int totalNQueens2(int n) {
        return dfs2(0,n,0,0,0);
    }

    private int dfs2(int depth, int n, int col, int main, int sub) {
        if(depth==n) return 1;
        int cnt=0;
        int available=((1<<n)-1) & ~(col|main|sub);
        while(available!=0){
            int pos=available & -available;
            cnt+=dfs2(depth+1,n,col|pos,(main|pos)<<1,(sub|pos)>>1);
            available&=available-1;
        }
        return cnt;
    }


    int count;

    public int totalNQueens(int n) {
        dfs(0,n,0,0,0);
        return count;
    }

    private void dfs(int depth, int n, int col, int main, int sub) {
        if(depth==n) count++;

        int available=((1<<n)-1) & ~(col|main|sub);
        while(available!=0){
            int pos=available & -available;
            dfs(depth+1,n,col|pos,(main|pos)<<1,(sub|pos)>>1);
            //下面这个可能更好理解一点,当前位置和对角线同时都要左移或右移，因为整个是靠每一轮循环来排除不可用位置的，available记录了之前的对角线位置
            //所以每一轮循环的时候，对角线都要继续左移或右移，这样才能将最初的对角线延伸
            //同时根据运算符的结合律，main<<1 | pos<<1  ==  (main|pos)<<1
//            dfs(depth+1,n,col|pos,main<<1|pos<<1,sub>>1|pos>>1);
            available&=available-1;
        }
    }
}
