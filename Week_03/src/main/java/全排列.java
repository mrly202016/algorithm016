import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列 https://leetcode-cn.com/problems/permutations/
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Deque<Integer> path=new ArrayDeque<>();
//        dfs(nums,0,used,path,lists);
        dfs2(nums,0,path,lists);
        return lists;
    }

    private void dfs2(int[] nums, int depth, Deque<Integer> path, List<List<Integer>> lists) {
        if(depth==nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=depth;i<nums.length;i++){
            //https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
            //官网解法交换，指针从depth位置往后移，将depth位置和后面比他大位置的数字交换，就是一种可能的组合，当前i如果就是depth位置，算是第一种可能，则不交换
            // [0,depth-1]位置是已经选过的数字
            // depth位置是待选的数字
            // [depth+1,nums.length()-1]位置是没有选过的数字
            path.addLast(nums[i]);
            swap(nums,depth,i);
            dfs2(nums,depth+1,path,lists);
            path.removeLast();
            swap(nums,depth,i);
        }
    }

    private void swap(int[] nums, int depth, int i) {
        if(i>depth){
            int temp=nums[i];
            nums[i]=nums[depth];
            nums[depth]=temp;
        }
    }

    private void dfs(int[] nums, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> lists) {//常规解法
        if(depth==nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,depth+1,used,path,lists);
                used[i]=false;
                path.removeLast();
            }
        }
    }
}
