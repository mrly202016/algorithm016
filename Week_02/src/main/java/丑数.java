/**
 * Leetcode做题-丑数  https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class 丑数 {
    public int nthUglyNumber(int n) {
        /**
         * 参考leetcode评论区大神解法，任何一个丑数都是由前面的任一个丑数乘上(2,3,5)得到的，
         * 由此转化成3个有序数组的合并去重，有序数组合并就用多指针的方式，然后后移
         */
        int a=0,b=0,c=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int a_num=dp[a]*2;
            int b_num=dp[b]*3;
            int c_num=dp[c]*5;
            dp[i]=Math.min(a_num,Math.min(b_num,c_num));
            if(dp[i]==a_num) a++;//a,b,c若值相等，指针都要后移
            if(dp[i]==b_num) b++;
            if(dp[i]==c_num) c++;
        }
        return dp[n-1];
    }
}
