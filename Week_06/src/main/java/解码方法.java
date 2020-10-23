/**
 * 解码方法  https://leetcode-cn.com/problems/decode-ways/
 */
public class 解码方法 {
    public static void main(String[] args) {
        解码方法 t=new 解码方法();
        System.out.println(t.numDecodings("11"));
//        System.out.println(t.numDecodings("10"));
//        System.out.println(t.numDecodings("1123"));
//        System.out.println(t.numDecodings("1201234"));
        System.out.println(t.numDecodings2("11"));
    }

    public int numDecodings2(String s) {//我感觉这个是从原始方案进一步优化，组合判断得来的，直接写不是很好理解
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()+1];//加1是为了少初始化一次i=1的情况,也满足dp[i]=dp[i-2]+dp[i-1]的下标要求
        //当为'11'时，有2种解码方法，但dp[1]的情况，即'1'时只有一种，所以dp[0]要等于1，才满足dp[i]=dp[i-2]+dp[i-1]
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;

        for (int i=2;i<dp.length;i++){
            //最后一位不为0，dp[i]至少有dp[i-1]种解码方法
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            // 1 0
            int num=10*(s.charAt(i-2)-'0')+s.charAt(i-1)-'0';
            //（1）组合当前位和前一位，大小为10以前的情况，即最后一位只能单独作为1位解码，则解码数量前面已经设置过，即dp[i]=dp[i-1]，跳过
            //（2）等于10或20的情况，则最后一位为0，只能跟前一位组合，解码方案为dp[i]=dp[i-2]，最后一位为0，前面的判断不会加上dp[i-1]
            //（3）组合当前位和前一位，大小为11～19，21～26的情况，解码方案为dp[i]=dp[i-1]+dp[i-2]，类似爬楼梯，最后一位不为0，前面已经加上了dp[i-1]
            //（4）组合当前位和前一位，大于26的情况，即最后一位只能单独作为1位解码，和（1）相同
            if(num>=10&&num<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[dp.length-1];
    }

    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()];
        dp[0]=s.charAt(0)=='0'?0:1;
        if(s.length()==1) return dp[0];
        int num=10*(s.charAt(0)-'0')+s.charAt(1)-'0';
        if(s.charAt(1)=='0'){
            if(num==0||num>20) return 0;
            dp[1]=1;
        }else {
            if(num<10||num>26){
                dp[1]=dp[0];
            }else {
                dp[1]=2;
            }
        }
        for(int i=2;i<dp.length;i++){
            int temp=10*(s.charAt(i-1)-'0')+s.charAt(i)-'0';
            //先看最后一位是否为0，如果为0，说明最后2位必须凑成一组2位的编码，不然把0当成最后一位则无解
            if(s.charAt(i)=='0'){
                //剔除异常情况，如果为'00'、'3～9'+'0'，则不能解码
                if(temp==0||temp>20) return 0;
                //最后2位凑成一组2位的编码，则只有一种方式，总的解码方式就看dp[i-2]
                dp[i]=dp[i-2];
            }else {
                //最后一位不为0，则最后一位有可能能和前一位形成组合解码
                if(temp<10||temp>26){
                    //先看最后一位只能单独作为一位解码的情况，即前一位+当前位等于'0'+'1~9'和大于'27'的组合
                    //则总的解码方式就看dp[i-1]
                    dp[i]=dp[i-1];
                }else {
                    //最后一位和前一位能形成组合，即'11'～'26'的情况
                    // 那就有点像爬楼梯，解码总和就等于最后一位单独作为一位的解码数量+最后2位作为组合的解码数量
                    dp[i]=dp[i-1]+dp[i-2];
                }
            }
        }
        return dp[dp.length-1];
    }
}
