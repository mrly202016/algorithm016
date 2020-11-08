/**
 * 位1的个数  https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class 位1的个数 {
    public int hammingWeight2(int n) {
        int count=0;
        while(n!=0){
            n&=n-1;
            count++;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int count=0;
        int k=32;
        while(k>0){
            count+=(n&1)==1?1:0;
            n>>>=1;
            k--;
        }
        return count;
    }
}
