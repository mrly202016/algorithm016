/**
 * 打家劫舍 II  https://leetcode-cn.com/problems/house-robber-ii/description/
 */
public class 打家劫舍II {
    public int rob6(int[] nums) {//优化5-推荐3
        if(nums.length==1) return nums[0];
        return Math.max(robFirst5(0,nums.length-2,nums),robFirst5(1,nums.length-1,nums));
    }

    private int robFirst5(int begin, int end, int[] nums) {
        int first=0,second=0,cur=0;
        for(int i=begin;i<=end;i++){
            cur=Math.max(second,first+nums[i]);
            first=second;
            second=cur;
        }
        return second;
    }

    public int rob5(int[] nums) {//优化4-推荐2
        if(nums.length==1) return nums[0];
        return Math.max(robFirst4(0,nums),robFirst4(1,nums));
    }

    private int robFirst4(int begin, int[] nums) {
        int first=0,second=0,cur=0;
        for(int i=2;i<nums.length+1;i++){
            cur=Math.max(second,first+nums[i-2+begin]);
            first=second;
            second=cur;
        }
        return second;
    }

    public int rob4(int[] nums) {//优化3-推荐1
        if(nums.length==1) return nums[0];
        return Math.max(robFirst3(0,nums),robFirst3(1,nums));
    }

    private int robFirst3(int begin, int[] nums) {
        int[] dp=new int[nums.length+1];//多前2个元素，默认为0
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-2+begin]);//这里要减去2，使nums从0开始
        }
        return dp[dp.length-1];
    }

    public int rob3(int[] nums) {//优化2
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robFirst2(0,nums),robFirst2(1,nums));
    }

    private int robFirst2(int begin, int[] nums) {
        int first=nums[begin];
        int second=Math.max(nums[begin],nums[begin+1]);
        int cur=0;
        for(int i=2;i<nums.length-1;i++){
            cur=Math.max(second,first+nums[i+begin]);
            first=second;
            second=cur;
        }
        return second;
    }

    public int rob2(int[] nums) {//优化
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robFirst(0,nums),robFirst(1,nums));
    }

    private int robFirst(int begin, int[] nums) {
        int[] dp=new int[nums.length-1];
        dp[0]=nums[begin];
        dp[1]=Math.max(nums[begin],nums[begin+1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+begin]);
        }
        return dp[dp.length-1];
    }

    public int rob(int[] nums) {//第一间偷，那最后一间就不能偷；第一间不偷，那最后一间就可以偷
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //第一间偷，最后一间不偷
        int[] dp1=new int[nums.length];
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }
        int first=dp1[nums.length-2];
        //第一间不偷，最后一间偷
        int[] dp2=new int[nums.length];
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        int second=dp2[nums.length-1];
        return Math.max(first,second);
    }
}
