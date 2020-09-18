import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode做题-删除最外层的括号 https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class 删除最外层的括号 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb=new StringBuilder();
        int left=0;
        for(char c:S.toCharArray()){
            if(c=='('&&left++>0){
                sb.append(c);
            }
            if(c==')'&&left-->1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
