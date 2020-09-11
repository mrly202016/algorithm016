import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode做题-滑动窗口最大值  https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] r = new int[nums.length-k+1];
        int r_index=0;
        Deque<Integer> deque=new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            //删除滑动窗口范围外的数据，也就是窗口左边届前面的数据
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            //从队列后端删除比当前数组值小的元素
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                r[r_index++] = nums[deque.peek()];
            }
        }

        return r;
    }
}
