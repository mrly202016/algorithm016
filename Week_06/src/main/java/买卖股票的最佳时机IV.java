import java.util.Arrays;

/**
 * 买卖股票的最佳时机IV  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class 买卖股票的最佳时机IV {
    public static void main(String[] args) {
        买卖股票的最佳时机IV t=new 买卖股票的最佳时机IV();
        System.out.println(t.maxProfit5(2,new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit5(int k, int[] prices) {//最大结果优化
        if(prices.length==0||k<=0) return 0;
        if(k>=prices.length/2){
            int sum=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    sum+=prices[i]-prices[i-1];
                }
            }
            return sum;
        }
        int[][] res=new int[2][k+1];
        for(int i=0;i<k+1;i++) res[1][i]=-prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    res[0][0]=0;
                    res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
                    continue;
                }
                res[0][j]=Math.max(res[0][j],res[1][j-1]+prices[i]);//这里已经比较过不持有股票的，所以最后直接返回res[0][k]即可
                res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
            }
        }
        return res[0][k];
    }

    public int maxProfit4(int k, int[] prices) {//交易次数优化
        if(prices.length==0||k<=0) return 0;
        if(k>=prices.length/2){
            int sum=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    sum+=prices[i]-prices[i-1];
                }
            }
            return sum;
        }
        int[][][] dp=new int[prices.length][2][k+1];
        for(int i=0;i<k+1;i++) dp[0][1][i]=-prices[0];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    dp[i][0][0]=0;
                    dp[i][1][j]=Math.max(dp[i-1][1][j],dp[i-1][0][j]-prices[i]);
                    continue;
                }
                dp[i][0][j]=Math.max(dp[i-1][0][j],dp[i-1][1][j-1]+prices[i]);
                dp[i][1][j]=Math.max(dp[i-1][1][j],dp[i-1][0][j]-prices[i]);
                if(j==k){
                    dp[i][0][j]=Math.max(dp[i-1][0][j],dp[i-1][1][j-1]+prices[i]);
                    dp[i][1][k]=dp[i-1][1][k];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k+1;i++) max=Math.max(max,dp[dp.length-1][0][i]);
        return max;
    }

    public int maxProfit3(int k, int[] prices) {//交易次数优化
        if(prices.length==0||k<=0) return 0;
        if(k>=prices.length/2){
            int sum=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]>prices[i-1]){
                    sum+=prices[i]-prices[i-1];
                }
            }
            return sum;
        }
        int[][] res=new int[2][k+1];
        for(int i=0;i<k+1;i++) res[1][i]=-prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    res[0][0]=0;
                    res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
                    continue;
                }
                res[0][j]=Math.max(res[0][j],res[1][j-1]+prices[i]);
                res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
                if(j==k){
                    res[0][j]=Math.max(res[0][j],res[1][j-1]+prices[i]);
                }
                max=Math.max(max,res[0][j]);
            }
        }
        return max;
    }

    public int maxProfit2(int k, int[] prices) {//空间优化
        if(prices.length==0||k<=0) return 0;
        if(k>prices.length/2) k=prices.length/2;
        int[][] res=new int[2][k+1];
        for(int i=0;i<k+1;i++) res[1][i]=-prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    res[0][0]=0;
                    res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
                    continue;
                }
                res[0][j]=Math.max(res[0][j],res[1][j-1]+prices[i]);
                res[1][j]=Math.max(res[1][j],res[0][j]-prices[i]);
                if(j==k){
                    res[0][j]=Math.max(res[0][j],res[1][j-1]+prices[i]);
                }
                max=Math.max(max,res[0][j]);
            }
        }
        return max;
    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length==0||k<=0) return 0;
        int[][][] dp=new int[prices.length][2][k+1];
        for(int i=0;i<k+1;i++) dp[0][1][i]=-prices[0];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    dp[i][0][0]=0;
                    dp[i][1][j]=Math.max(dp[i-1][1][j],dp[i-1][0][j]-prices[i]);
                    continue;
                }
                dp[i][0][j]=Math.max(dp[i-1][0][j],dp[i-1][1][j-1]+prices[i]);
                dp[i][1][j]=Math.max(dp[i-1][1][j],dp[i-1][0][j]-prices[i]);
                if(j==k){
                    dp[i][0][j]=Math.max(dp[i-1][0][j],dp[i-1][1][j-1]+prices[i]);
                    dp[i][1][k]=dp[i-1][1][k];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k+1;i++) max=Math.max(max,dp[dp.length-1][0][i]);
        return max;
    }
}
