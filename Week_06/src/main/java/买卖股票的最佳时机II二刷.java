/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/10/13
 * Time: 18:13
 */
public class 买卖股票的最佳时机II二刷 {
    public int maxProfit3(int[] prices) {
        int pre_no=0;
        int pre_yes=-prices[0];
        for(int i=1;i<prices.length;i++){
            pre_no=Math.max(pre_no,pre_yes+prices[i]);
            pre_yes=Math.max(pre_yes,pre_no-prices[i]);
        }
        return pre_no;
    }

    public int maxProfit2(int[] prices) {//动态规划
        int[][] dp=new int[prices.length][2];//0-不持有股票，1-持有股票
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[dp.length-1][0];
    }

    public int maxProfit(int[] prices) {//贪心算法
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                sum+=prices[i]-prices[i-1];
            }
        }
        return sum;
    }
}
