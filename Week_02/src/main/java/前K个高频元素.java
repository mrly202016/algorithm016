import java.util.*;

/**
 * Leetcode做题-前K个高频元素  https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class 前K个高频元素 {
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        /*Queue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));//这个很巧妙，用int[]存映射
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(queue.size()==k){
                if(entry.getValue()>queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }else {
                queue.offer(new int[]{entry.getKey(),entry.getValue()});
            }
        }

        int[] r=new int[k];
        while (k>0){
            r[k-1]=queue.poll()[0];
            k--;
        }*/

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o->map.get(o)));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(queue.size()<k){
                queue.offer(entry.getKey());
            }else {
                if(entry.getValue()>map.get(queue.peek())){
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }

        int[] r=new int[k];
        while (k>0){
            r[k-1]=queue.poll();
            k--;
        }

        return r;
    }
}
