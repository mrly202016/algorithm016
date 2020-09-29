/**
 * Pow(x, n)  https://leetcode-cn.com/problems/powx-n/
 */
public class PowXN {
    public double myPowLoop(double x, int n) {
        if(x==0){
            return 0;
        }
        long N=n;
        return n>=0?loop(x,N):1/loop(x,-N);
    }

    private double loop(double x, long n) {
        //https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
        //这个涉及一些二进制的转化和等比数列运算
        double r=1;
        double temp=x;
        while (n>0){
            if((n&1)==1){
                r*=temp;
            }
            temp*=temp;
            n>>=1;
        }
        return r;
    }

    public double myPow(double x, int n) {
        long N=n;//这里转换成long是因为int最小值，转成正数会溢出
        return n>=0?_recursion(x,N):1/_recursion(x,-N);
    }

    private double _recursion(double x, long n) {
        if(n==0){
            return 1;
        }
        double r=_recursion(x,n/2);
        return n%2==0?r*r:r*r*x;
    }
}
