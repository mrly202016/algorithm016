import java.util.Arrays;

/**
 * 任务调度器  https://leetcode-cn.com/problems/task-scheduler/
 */
public class 任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        //看这个大哥思路，讲解是最清晰的：https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
        int[] counts=new int[26];
        for(char c:tasks) counts[c-'A']++;
        Arrays.sort(counts);
        int index=25;
        while(index>=0&&counts[index]==counts[25]) index--;
        int rest=25-index;
        int bulk=(counts[25]-1)*(n+1);
        return (tasks.length-rest)>=bulk?tasks.length:(bulk+rest);
    }
}
