/**
 * 买卖股票的最佳时机含手续费  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class 买卖股票的最佳时机含手续费 {
    public int maxProfit2(int[] prices, int fee) {
        int pre_no=0,pre_yes=-prices[0];
        for(int i=1;i<prices.length;i++){
            int temp=pre_no;
            pre_no=Math.max(pre_no,pre_yes+prices[i]-fee);
            pre_yes=Math.max(pre_yes,temp-prices[i]);
        }
        return pre_no;
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[dp.length-1][0];
    }

}
