/**
 * 最佳买卖股票时机含冷冻期  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit2(int[] prices) {
        if(prices.length==0) return 0;
        int pre_no_not=0,pre_no_yes=0,pre_yes_not=-prices[0];
        for(int i=1;i<prices.length;i++){
            int temp=pre_no_not;
            pre_no_not=Math.max(pre_no_not,pre_no_yes);
            pre_no_yes=pre_yes_not+prices[i];
            pre_yes_not=Math.max(pre_yes_not,temp-prices[i]);
        }
        return Math.max(pre_no_not,pre_no_yes);
    }

    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        //2  [0-不持有股票  1-持有股票]
        //2  [0-没有交易   1-交易了]  没有交易就是没有卖掉，交易了就是卖掉了
        int[][][] dp=new int[prices.length][2][2];
        dp[0][0][0]=0;
        dp[0][0][1]=0;
        dp[0][1][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            //首先排除昨天持有股票的情况，因为昨天如果持有股票，今天是不持有股票，那今天肯定要交易掉，那就与当前dp[i][0][0]不符
            dp[i][0][0]=Math.max(dp[i-1][0][0],dp[i-1][0][1]);
            //今天不持有股票并且还要交易掉，那昨天必须是持有股票并且没有交易的状态
            dp[i][0][1]=dp[i-1][1][0]+prices[i];
            //今天持有股票并且今天不交易掉，那肯定不会从dp[i-1][1][1]过来，因为交易掉之后今天不可能持有股票
            //也不可能从dp[i-1][0][1]过来，因为昨天不持有股票，今天持有股票，那今天肯定要买，那昨天就不能交易，必须处于冷冻期，矛盾
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
        }
        return Math.max(dp[dp.length-1][0][0],dp[dp.length-1][0][1]);
    }
}
