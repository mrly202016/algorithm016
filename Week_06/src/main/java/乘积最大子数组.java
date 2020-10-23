/**
 * 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/description/
 */
public class 乘积最大子数组 {
    public int maxProduct3(int[] nums) {//空间优化
        int pre_max=nums[0],pre_min=nums[0],max=nums[0];
        int cur_max=0,cur_min=0;
        for(int i=1;i<nums.length;i++){
            cur_max=Math.max(nums[i],Math.max(pre_max*nums[i],pre_min*nums[i]));
            cur_min=Math.min(nums[i],Math.min(pre_max*nums[i],pre_min*nums[i]));
            max=Math.max(max,cur_max);
            pre_max=cur_max;
            pre_min=cur_min;
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int[] dp_max=new int[nums.length];
        int[] dp_min=new int[nums.length];
        dp_max[0]=nums[0];
        dp_min[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            dp_max[i]=Math.max(nums[i],Math.max(dp_max[i-1]*nums[i],dp_min[i-1]*nums[i]));
            dp_min[i]=Math.min(nums[i],Math.min(dp_max[i-1]*nums[i],dp_min[i-1]*nums[i]));
            max=Math.max(max,dp_max[i]);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int[][] dp=new int[nums.length][2];
        dp[0][0]=nums[0];//每一轮最大值
        dp[0][1]=nums[0];//每一轮最小值
        int max=nums[0];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=Math.max(nums[i],Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            dp[i][1]=Math.min(nums[i],Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            max=Math.max(max,dp[i][0]);
        }
        return max;
    }
}
