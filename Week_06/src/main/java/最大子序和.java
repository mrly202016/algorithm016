/**
 * 最大子序和  https://leetcode-cn.com/problems/maximum-subarray/
 */
public class 最大子序和 {
    public int maxSubArray3(int[] nums) {//正数的增益性，sum如果小于0，那加上num[i]肯定更小，这时候sum应该为nums[i]
        int sum=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=sum>=0?sum+nums[i]:nums[i];
            max=Math.max(max,sum);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {//空间优化
        int pre=0,max=nums[0];
        for(int i=0;i<nums.length;i++){
            pre=Math.max(pre+nums[i],nums[i]);
            max=Math.max(max,pre);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);//这个最大就确保了连续性
        }
        return max;
    }
}
