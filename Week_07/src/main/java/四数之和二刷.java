import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和二刷
 */
public class 四数之和二刷 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            //剪枝
            int curMin_i=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            int curMax_i=nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1];
            if(curMin_i>target) break;
            if(curMax_i<target) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j-1]==nums[j]) continue;
                //剪枝
                int curMin_j=nums[i]+nums[j]+nums[j+1]+nums[j+2];
                int curMax_j=nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1];
                if(curMin_j>target) break;
                if(curMax_j<target) continue;

                int m=j+1,r=nums.length-1,targetNum=target-nums[i]-nums[j];
                while(m<r){
                    if(nums[m]+nums[r]==targetNum){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[r]);
                        lists.add(list);
                        while(m<r&&nums[m]==nums[m+1]) m++;
                        while(m<r&&nums[r]==nums[r-1]) r--;
                        m++;r--;
                    }else if(nums[m]+nums[r]>targetNum) r--;
                    else m++;
                }
            }
        }
        return lists;
    }
}
