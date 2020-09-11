import java.util.Stack;

/**
 * leetcode做题-最小栈  https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack2 {
    public static void main(String[] args) {
        MinStack2 minStack2=new MinStack2();
        minStack2.push(512);
        minStack2.push(-1024);
        minStack2.push(-1024);
        minStack2.push(512);
        minStack2.pop();
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.getMin());
    }

    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public MinStack2() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x=dataStack.pop();
        if(x==minStack.peek()){
            minStack.pop();
        }
        //不能用下面这种写法，因为比较的是Integer地址，2个并不相同
        /*if(dataStack.pop()==minStack.peek()){
            minStack.pop();
        }*/
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
