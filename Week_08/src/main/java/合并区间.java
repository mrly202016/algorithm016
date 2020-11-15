import java.util.*;

/**
 * 合并区间  https://leetcode-cn.com/problems/merge-intervals/
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] ints=new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        合并区间 t=new 合并区间();
        t.merge(ints);
    }

    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> stack=new ArrayDeque<>();
        stack.addFirst(intervals[0]);
        for(int[] arr:intervals){
            int[] last=stack.getFirst();
            if(last[1]<arr[0]){
                stack.addFirst(arr);
            }else {
                last[1]=Math.max(last[1],arr[1]);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
}
