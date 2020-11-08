/**
 * 2的幂  https://leetcode-cn.com/problems/power-of-two/
 */
public class 二的幂 {
    public boolean isPowerOfTwo(int n) {
        int count=0;
        while(n>0){
            n&=n-1;
            count++;
        }
        return count==1;
    }
}
