/**
 * 解码方法
 */
public class 解码方法二刷 {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;

        for (int i=2;i<dp.length;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            int num=10*(s.charAt(i-2)-'0')+s.charAt(i-1)-'0';
            if(num>=10&&num<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
}
