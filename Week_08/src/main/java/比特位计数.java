/**
 * 比特位计数  https://leetcode-cn.com/problems/counting-bits/description/
 */
public class 比特位计数 {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        //无论奇偶，右移一位（也就是除以2）之后，2者1的个数只差最后一位，奇数最后一位为1，偶数最后一位为0
        for(int i=1;i<=num;i++) dp[i]=dp[i>>1]+(i&1);
        return dp;
    }
}
