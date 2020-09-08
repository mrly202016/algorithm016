import java.util.*;

/**
 * leetcode做题-两数之和  https://leetcode-cn.com/problems/3sum/
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        for(int l=0;l<nums.length-2;l++){
            if(l-1>=0&&nums[l-1]==nums[l]){//去重
                continue;
            }
            int m=l+1,r=nums.length-1,target=-nums[l];
            while(m<r){
                if(nums[m]+nums[r]==target){
                    lists.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    //去重
                    while(m<r&&nums[m]==nums[m+1]) m++;
                    while (m<r&&nums[r]==nums[r-1]) r--;
                    //这里同盛最多水的容器指针移动判断思路
                    m++;
                    r--;
                }else if(nums[m]+nums[r]>target){
                    r--;
                }else {
                    m++;
                }
            }
        }
        return lists;
    }
}
