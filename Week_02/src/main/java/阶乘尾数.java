/**
 * Leetcode做题-阶乘尾数 https://leetcode-cn.com/problems/factorial-zeros-lcci/
 */
public class 阶乘尾数 {
    public int trailingZeroes(int n) {
        int count=0;
        while (n>=5){
            n=n/5;
            count+=n;
        }
        return count;
    }
}
