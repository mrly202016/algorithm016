/**
 * 有效的完全平方数  https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        long l=0,r=num,mid=0;
        while (l<=r){
            mid=(l+r)>>>1;
            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return false;
    }
}
