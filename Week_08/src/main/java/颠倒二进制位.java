/**
 * 颠倒二进制位  https://leetcode-cn.com/problems/reverse-bits/
 */
public class 颠倒二进制位 {
    public int reverseBits(int n) {
        int k=1;
        int ans=0;
        while(k<=32){
            ans|=(n&1)<<(32-k);
            n>>>=1;
            k++;
        }
        return ans;
    }
}
