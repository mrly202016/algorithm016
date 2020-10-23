/**
 * 打家劫舍  https://leetcode-cn.com/problems/house-robber/
 */
public class 打家劫舍 {
    public int rob3(int[] nums) {//优化2
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int prev_prev=nums[0];
        int prev=Math.max(nums[0],nums[1]);
        int cur=0;
        for(int i=2;i<nums.length;i++){
            cur=Math.max(prev,prev_prev+nums[i]);
            prev_prev=prev;
            prev=cur;
        }
        return prev;
    }

    public int rob2(int[] nums) {//优化
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);//这间屋子最大值就是前一间屋子偷了和前前一间屋子偷了+这间屋子金额的最大值
        }
        return dp[dp.length-1];
    }

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[][] dp=new int[nums.length][2];
        dp[0][0]=0;//没偷
        dp[0][1]=nums[0];//偷了
        for(int i=1;i<dp.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);//这间屋子不偷，那这间屋子最大金额就是前面一间屋子偷或不偷的最大值
            dp[i][1]=dp[i-1][0]+nums[i];//这间屋子偷，那这间屋子就是前面那间屋子不偷+这间屋子的金额
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}
