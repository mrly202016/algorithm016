import java.util.Arrays;

/**
 * 零钱兑换  https://leetcode-cn.com/problems/coin-change/
 */
public class 零钱兑换 {
    public int coinChangeTanxin(int[] coins, int amount) {//回溯+剪枝
        Arrays.sort(coins);
        recursion(coins,coins.length-1,amount,0);
        return r==Integer.MAX_VALUE?-1:r;
    }

    private void recursion(int[] coins, int coinIndex, int amount, int count) {
        if(amount==0){
            r=Math.min(r,count);
            return;
        }
        if(coinIndex<0){
            return;
        }
        for(int k=amount/coins[coinIndex];k>=0&&count+k<r;k--){
            recursion(coins,coinIndex-1,amount-k*coins[coinIndex],count+k);
        }
    }

    public int coinChange_Up_to_Down(int[] coins, int amount) {//由上而下，记录中间结果法
        int[] memo=new int[amount+1];
        return findWay(coins,amount,memo);
    }

    private int findWay(int[] coins, int amount, int[] memo) {
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(memo[amount]!=0){
            return memo[amount];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int r=findWay(coins,amount-coins[i],memo);
            if(r!=-1){
                min=Math.min(min,r);
            }
        }
        memo[amount]=min==Integer.MAX_VALUE?-1:min+1;
        return memo[amount];
    }

    Integer r=Integer.MAX_VALUE;
    public int coinChange_Recursion(int[] coins, int amount) {//原始递归
        _recursion(coins,amount,0);
        return r==Integer.MAX_VALUE?-1:r;
    }

    private void _recursion(int[] coins, int amount, int count) {
        if(amount<0){
            return;
        }
        if(amount==0){
            r=Math.min(r,count);
        }
        for(int i=0;i<coins.length;i++){
            _recursion(coins,amount-coins[i],count+1);
        }
    }

    public int coinChange(int[] coins, int amount) {//dp
        if(amount<=0){
            return 0;
        }
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
