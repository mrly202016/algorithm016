import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合  https://leetcode-cn.com/problems/combinations/
 */
public class 组合 {
    //https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
    //这个大哥的解题思路很清晰，把回溯讲的很清楚
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList<>();
        if(n<k||k<=0){
            return lists;
        }
        Deque<Integer> path=new ArrayDeque<>();
//        dfs(n,k,1,path,lists);//回溯未剪枝
        dfs2(n,k,1,path,lists);//回溯剪枝
        return lists;
    }

    private void dfs2(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> lists) {
        if(path.size()==k){
            lists.add(new ArrayList(path));
            return;
        }
        //n-i可以起始的最大位置+1=k-path.size
        //所以i的上界是i=n-(k-path.size())+1
        for(int i=begin;i<=n-(k-path.size())+1;i++){
            path.addLast(i);
            dfs(n,k,i+1,path,lists);
            path.removeLast();
        }
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> lists) {
        if(path.size()==k){
            lists.add(new ArrayList(path));
            return;
        }
        for(int i=begin;i<=n;i++){
            path.addLast(i);
            dfs(n,k,i+1,path,lists);
            path.removeLast();
        }
    }
}
