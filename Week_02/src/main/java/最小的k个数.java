import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode做题-最小的k个数  https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class 最小的k个数 {
    public static void main(String[] args) {
        getLeastNumbers2(new int[]{4,5,1,6,2,7,3,8}, 3);
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue=new PriorityQueue<>();
        for(int i:arr){
            queue.add(i);
        }
        int[] r=new int[k];
        while (k>0){
            r[k-1]=queue.remove();
            k--;
        }
        return r;
    }
}
