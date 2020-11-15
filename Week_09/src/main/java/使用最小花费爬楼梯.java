/**
 * 使用最小花费爬楼梯  https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        使用最小花费爬楼梯 t=new 使用最小花费爬楼梯();
        t.minCostClimbingStairs(new int[]{10,15,20});
    }

    public int minCostClimbingStairs2(int[] cost) {
        int first=0,second=0,cur=0;
        for(int i=2;i<cost.length+1;i++){
            cur=Math.min(second+cost[i-1],first+cost[i-2]);
            first=second;
            second=cur;
        }
        return cur;
    }

    public int minCostClimbingStairs(int[] cost) {
        //根据题目意思，这个题目里最后一级台阶并不是楼梯顶，真正要到达的位，是最后一级台阶再上一阶，到达顶部
        int[] dp=new int[cost.length+1];
        //起始位置可以是下标为0的台阶或下标为1的台阶，站在起始位置时，dp[0]或dp[1]为0，可以把0或1理解为台阶顶
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++){
            //状态转移方程：到达台阶顶分2种情况：
            //从最后一级台阶走一步到达台阶顶：dp[i-1]+cost[i-1]
            //从倒数第二级台阶走两步到达台阶顶：dp[i-2]+cost[i-2]
            //取以上2种情况的最小值即可
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
