import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 子集  https://leetcode-cn.com/problems/subsets/
 */
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        dfs(nums,0,path,lists);
        return lists;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(path));
        for(int i=depth;i<nums.length;i++){
            path.addLast(nums[i]);
            dfs(nums,i+1,path,lists);
            path.removeLast();
        }
    }
}
