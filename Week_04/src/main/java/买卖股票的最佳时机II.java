/**
 * 买卖股票的最佳时机 II   https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class 买卖股票的最佳时机II {
    public int maxProfit_DP(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for(int i=1;i<prices.length;i++){
            //今天没有股票：（1）昨天没有股票，今天没有操作；（2）昨天有股票，今天卖了，按今天的股价赚了
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //今天有股票：（1）昨天就有股票，今天没有操作；（2）昨天没有股票，今天买了，按今天的股价亏了
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
