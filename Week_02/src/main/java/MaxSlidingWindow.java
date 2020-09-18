import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * MaxSlidingWindow
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0){
            return new int[0];
        }
        int[] r=new int[nums.length-k+1];
        int index=0;
        Deque<Integer> queue=new ArrayDeque<>();//存下标
        for(int i=0;i<nums.length;i++){
            while (!queue.isEmpty()&&queue.peek()<=i-k){
                queue.remove();
            }
            while (!queue.isEmpty()&&nums[i]>nums[queue.peekLast()]){
                queue.removeLast();
            }
            queue.add(i);
            if(i>=k-1){
                r[index++]=nums[queue.peek()];
            }
        }
        return r;
    }
}
