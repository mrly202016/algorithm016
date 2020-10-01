import java.util.*;

/**
 * 括号生成二刷
 */
public class 括号生成二刷 {
    public List<String> generateParenthesis_BFS(int n) {
        //https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
        return null;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        char[] chars=new char[2*n];
        dfs(0,0,n,chars,list);
        return list;
    }

    private void dfs(int l, int r, int n, char[] path, List<String> list) {
        if(l==n&&r==n){
            list.add(new String(path));
            return;
        }
        if(l<n){
            path[l+r]='(';
            dfs(l+1,r,n,path,list);
            path[l+r]=0;
        }
        if(r<l&&r<n){
            path[l+r]=')';
            dfs(l,r+1,n,path,list);
            path[l+r]=0;
        }
    }
}
