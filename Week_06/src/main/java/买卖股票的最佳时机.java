/**
 * 买卖股票的最佳时机  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
 */
public class 买卖股票的最佳时机 {
    public int maxProfit3(int[] prices) {//动态规划
        if(prices.length==0) return 0;
        int pre_no=0;
        int pre_yes=-prices[0];
        for(int i=1;i<prices.length;i++){
            pre_no=Math.max(pre_no,pre_yes+prices[i]);
            pre_yes=Math.max(pre_yes,-prices[i]);
        }
        return pre_no;
    }

    public int maxProfit2(int[] prices) {//动态规划
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
        if(prices.length==0) return 0;
        int[][] dp=new int[prices.length][2];//0-不持有股票，1-持有股票
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);//今天不持有股票可以由昨天不持有股票转移过来，也可以是昨天持有股票，今天卖了
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);//今天持有股票可以由昨天持有股票转移过来，也可以是今天买的，那么利润就是-prices[i]
        }
        return dp[prices.length-1][0];//不持有股票肯定比持有股票赚钱
    }

    public int maxProfit(int[] prices) {//记录从开始到当前位置到最低股价，用当前值减去最低股价和最大股价进行比较
        int min=Integer.MAX_VALUE,max=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
