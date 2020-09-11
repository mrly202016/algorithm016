import java.util.Stack;

/**
 * leetcode做题-最小栈  https://leetcode-cn.com/problems/min-stack/
 */
public class 最小栈 {
    int min=Integer.MAX_VALUE;
    Stack<Integer> stack=new Stack<>();

    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(min==stack.pop()){
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
