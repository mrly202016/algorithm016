import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode做题-有效的括号  https://leetcode-cn.com/problems/valid-parentheses/
 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Deque<String> stack=new ArrayDeque<>();
        char[] chars=s.toCharArray();
        for(char ch:chars){
            switch (ch){
                case '(':
                    stack.addFirst("(");
                    break;
                case '{':
                    stack.addFirst("{");
                    break;
                case '[':
                    stack.addFirst("[");
                    break;
                case ')':
                    if(!"(".equals(stack.pollFirst())){
                        return false;
                    }
                    break;
                case '}':
                    if(!"{".equals(stack.pollFirst())){
                        return false;
                    }
                    break;
                case ']':
                    if(!"[".equals(stack.pollFirst())){
                        return false;
                    }
                    break;
            }
        }

        if(stack.size()>0){
            return false;
        }
        return true;
    }
}
