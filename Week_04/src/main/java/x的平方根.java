/**
 * x 的平方根  https://leetcode-cn.com/problems/sqrtx/
 */
public class x的平方根 {
    public static void main(String[] args) {
        x的平方根 t=new x的平方根();
        t.mySqrt(8);
    }

    public int mySqrt(int x) {
        long l=0,r=x,mid=0;
        while (l<r){
            mid=(l+1+r)>>>1;
            if(mid*mid<=x){
                //l=mid时mid取右中位数，即(l+1+r)>>>1，不然l始终等于自身，死循环
                //r=mid时mid取左中位数，即(l+r)>>>1，不然r始终等于自身，死循环
                l=mid;
            }else {
                r=mid-1;
            }
        }
        return (int) l;
    }
}
