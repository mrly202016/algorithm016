import java.util.*;

/**
 * 全排列 II  https://leetcode-cn.com/problems/permutations-ii/
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);//排序是为了解决重复元素的问题
        dfs(nums,used,0,path,lists);
        return lists;
    }

    private void dfs(int[] nums,boolean[] used, int depth, Deque<Integer> path, List<List<Integer>> lists) {
        if(depth==nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //官方题解这样理解
            //used[i]=true时好理解
            //nums[i]==nums[i-1]表示排序后，如果for循环里下一个元素和前一个元素相同，那就不必再排列了，重复了
            //但是如果只加nums[i]==nums[i-1]，那么前一个元素在递归的时候，遇到下一层，它的下一个元素时，就会认为重复，不参与排列，所以要加!used[i-1]
            //加了!used[i-1]这个表示前一个元素如果没有被使用，就跳过循环。这么做就让排序后紧邻的一堆元素，只有排在最前面的元素会参与排列，
            //因为最前面的元素递归到下一层时，本身已经是used了，所以!used[i-1]=false，会参与排列。而后面跟它相同的元素，本身是used，但是前一个并没有used，所以不会参与排列
            //简单来说就是，在循环中，兄弟元素之间只允许相同元素的第一个元素参与排列，其他不允许
            //!used[i-1]不加！取反也行，就是反着来，表示只让兄弟元素中相同的元素的最后一个参与排列
            if(used[i]||(i-1>=0&&nums[i]==nums[i-1]&&!used[i-1])){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,used,depth+1,path,lists);
            used[i]=false;
            path.removeLast();
        }
    }

}
