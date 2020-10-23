import java.util.Arrays;

/**
 * 零钱兑换  https://leetcode-cn.com/problems/coin-change/description/
 */
public class 零钱兑换二刷 {
    public int coinChange_tanxin(int[] coins, int amount) {
        Arrays.sort(coins);
        _recursion(0,coins.length-1,coins,amount);
        return min==Integer.MAX_VALUE?-1:min;
    }

    Integer min=Integer.MAX_VALUE;
    private void  _recursion(int count, int index, int[] coins, int amount) {
        if(amount==0){
            min=count;
        }
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0&&c+count<min;c--){
            _recursion(count+c,index-1,coins,amount-c*coins[index]);
        }
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
