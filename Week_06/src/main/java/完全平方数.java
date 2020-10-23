/**
 * 完全平方数  https://leetcode-cn.com/problems/perfect-squares/
 */
public class 完全平方数 {
    public int numSquares(int n) {//跟零钱兑换差不多
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;j<n;j++){
                if(i-j*j>=0){
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
}
