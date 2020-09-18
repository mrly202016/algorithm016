/**
 * Leetcode做题-各位相加 https://leetcode-cn.com/problems/add-digits/
 */
public class 各位相加 {
    public int addDigitsMath(int num) {
        return (num-1)%9+1;
    }

    public int addDigits(int num) {
        int sum=0;
        while (num>9||sum>0){
            if(num==0){
                num=sum;
                sum=0;
                continue;
            }
            sum+=num%10;
            num=num/10;
        }
        return num;
    }
}
