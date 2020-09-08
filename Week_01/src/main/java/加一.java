import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * leetcode做题-加一  https://leetcode-cn.com/problems/plus-one/
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }

        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

}
