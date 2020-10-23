import java.util.Arrays;

/**
 * 零钱兑换 II  https://leetcode-cn.com/problems/coin-change-2/
 */
public class 零钱兑换II {
    public static void main(String[] args) {
        零钱兑换II t=new 零钱兑换II();
        System.out.println(t.change(5,new int[]{1,2,5}));
    }

    public int change1(int amount, int[] coins) {//空间优化
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int[] cur=new int[amount+1];
        cur[0]=1;
        for(int i=coins[0];i<=amount;i+=coins[0]) cur[i]=1;
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j-coins[i]>=0) cur[j]+=cur[j-coins[i]];
            }
        }
        return cur[amount];
    }

    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int[][] dp=new int[coins.length][amount+1];
        //金额为0，分2种情况：
        // （1）amont-conins[i]=0，即单个硬币即可凑成金额，那方法是1，即dp[i][0]都是1；
        // （2）原始amont=0，那就采用0个硬币组合，方法是1个；也跟上面（1）相呼应
        dp[0][0]=1;
        //初始化第一行，所有能通过第一个硬币的整数倍构成的金额，方案都是1种
        for(int i=coins[0];i<=amount;i+=coins[0]) dp[0][i]=1;
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]+=dp[i-1][j];
                if(j-coins[i]>=0) dp[i][j]+=dp[i][j-coins[i]];
            }
        }
        return dp[coins.length-1][amount];
    }
}
