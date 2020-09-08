import java.util.HashMap;
import java.util.Map;

/**
 * leetcode做题-两数之和  https://leetcode-cn.com/problems/two-sum/
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map map=new HashMap();
        for(int i=0;i<nums.length;i++){
            int _2=target-nums[i];
            if(map.containsKey(_2)){
                return new int[]{(int) map.get(_2), i};
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
