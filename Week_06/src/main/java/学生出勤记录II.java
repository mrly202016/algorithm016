/**
 * 学生出勤记录II  https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class 学生出勤记录II {
    /**
     * 一开始题意理解错了，题目说的意思是连续的字符排列中不能超过1个A或连续2个L
     * 那像 PPPAPPLLPPLLPP 这种其实是可以的，
     */
    public int checkRecord(int n) {
        int mod=1000000007;
        //2-表示A只能有0或1个，3-表示末尾连续的L只能有0、1或2个
        long[][][] dp=new long[n+1][2][3];
        dp[1][0][0]=1;//"P"
        dp[1][0][1]=1;//"L"
        dp[1][0][2]=0;//n=1，只能放1个L
        dp[1][1][0]=1;//"A"
        dp[1][1][1]=0;
        dp[1][1][2]=0;

        for(int i=2;i<=n;i++){
            //0A0L+P   0A1L+P  0A2L+P
            dp[i][0][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%mod;
            //0A0L+L
            dp[i][0][1]=dp[i-1][0][0];
            //0A1L+L
            dp[i][0][2]=dp[i-1][0][1];
            //0A0L+A   0A1L+A    0A2L+A   1A0L+P   1A1L+P   1A2L+P
            dp[i][1][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%mod+(dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2])%mod;
            //1A0L+L
            dp[i][1][1]=dp[i-1][1][0];
            //1A1L+L
            dp[i][1][2]=dp[i-1][1][1];
        }

        return (int) ((dp[n][0][0]+dp[n][0][1]+dp[n][0][2]+dp[n][1][0]+dp[n][1][1]+dp[n][1][2])%mod);
    }
}
