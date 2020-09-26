import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode做题-括号生成  https://leetcode-cn.com/problems/generate-parentheses/
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        _recursion(0,0,n,"",list);
        return list;
    }

    private void _recursion(int l, int r, int n,String str, List<String> list) {
        if(l==n&&r==n){
            list.add(str);
            return;
        }

        if(l<n) _recursion(l+1,r,n,str+"(",list);
        if(l>r&&r<n) _recursion(l,r+1,n,str+")",list);
    }
}
