import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode做题-柱状图中最大的矩形  https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        for (int i = 0; i <= heights.length; i++) {
            int h=0;
            if(i!=heights.length){
                h=heights[i];
            }
            //严格小于栈顶元素的时候计算面积
            while (stack.peek() != -1 && h < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            //大于等于栈顶元素都压栈
            stack.push(i);
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        for (int i = 0; i < heights.length; i++) {
            //严格小于栈顶元素的时候计算面积
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            //大于等于栈顶元素都压栈
            stack.push(i);
        }

        while (stack.peek() != -1) {//剩余元素计算面积
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }
}
