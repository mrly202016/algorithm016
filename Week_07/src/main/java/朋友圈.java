/**
 * 朋友圈  https://leetcode-cn.com/problems/friend-circles/
 */
public class 朋友圈 {
    public int findCircleNum3(int[][] M) {
        int count=0;
        boolean[] visited=new boolean[M.length];
        for(int i=0;i<M.length;i++){
            if(!visited[i]) {
                count++;
                dfs(M,i,visited);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1&&!visited[j]){
                visited[j]=true;
                dfs(M,j,visited);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int count=0;
        for(int i=0;i<M.length;i++){
            if(M[i][i]==1) {
                count++;
                dfs(M,i);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i) {
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1){
                M[i][j]=M[j][i]=0;
                dfs(M,j);
            }
        }
    }

    public int findCircleNum(int[][] M) {//并查集
        UnionFind union=new UnionFind(M.length);
        for(int i=0;i<M.length;i++){
            for(int j=0;j<i;j++){
                if(M[i][j]==1) union.union(i,j);
            }
        }
        return union.count;
    }

    class UnionFind{
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent=new int[n];
            count=n;
            for(int i=0;i<n;i++) parent[i]=i;
        }

        /**
         * 指针压缩
         * c->b->a ==>  b->a,c->a    b和c变为平级，使得查找c的parent只需要O(1)
         */
        int find(int p){
            while(parent[p]!=p){
                parent[p]=parent[parent[p]];//指针压缩
                p=parent[p];
            }
            return p;
        }

        void union(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);
            if(rootP==rootQ) return;//p和q已经在一个集合里，返回
            parent[rootP]=rootQ;//也可以反过来parent[rootQ]=rootP
            count--;//因为p和q合并了，集合数量要减1
        }
    }
}
