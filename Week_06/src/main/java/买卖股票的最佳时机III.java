import java.util.Arrays;

/**
 * 买卖股票的最佳时机 III  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class 买卖股票的最佳时机III {
    public static void main(String[] args) {
        买卖股票的最佳时机III t=new 买卖股票的最佳时机III();
        System.out.println(t.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(t.maxProfit(new int[]{1,2,3,4,5}));
    }

    public int maxProfit3(int[] prices) {//优化
        int pre_no_one=0,pre_no_two=0;
        int pre_yes_zero=-prices[0],pre_yes_one=-prices[0];
        for(int i=1;i<prices.length;i++){
            pre_no_one=Math.max(pre_no_one,pre_yes_zero+prices[i]);
            pre_no_two=Math.max(pre_no_two,pre_yes_one+prices[i]);
            pre_yes_zero=Math.max(pre_yes_zero,-prices[i]);
            pre_yes_one=Math.max(pre_yes_one,pre_no_one-prices[i]);
        }
        return Math.max(pre_no_one,pre_no_two);
    }

    public int maxProfit(int[] prices) {
        //2 [0-不持有股票  1-持有股票]
        //3 [0-交易0次  1-交易1次   2-交易2次]  交易指买卖过一次
        int[][][] dp=new int[prices.length][2][3];
        //第一天不持有股票都是0
        dp[0][0][0]=0;
        dp[0][0][1]=0;
        dp[0][0][2]=0;
        //第一天持有股票都是-prices[0]
        dp[0][1][0]=-prices[0];
        dp[0][1][1]=-prices[0];
        dp[0][1][2]=-prices[0];
        for(int i=1;i<dp.length;i++){
            dp[i][0][0]=0;
            dp[i][0][1]=Math.max(dp[i-1][0][1],dp[i-1][1][0]+prices[i]);//昨天持有股票没有卖，也就没有完成交易，次数为0，今天卖，次数为1
            dp[i][0][2]=Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i]);
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);//有个前提，第二次买入时，第一次买入的必须先卖掉
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
            dp[i][1][2]=dp[i-1][1][2];//不能交易2次以上，只能有前一天完成2次交易的状态转过来
        }
        return Math.max(dp[dp.length-1][0][1],dp[dp.length-1][0][2]);
    }
}
