/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/9/7
 * Time: 22:06
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(30));
        System.out.println(climbStairs_recursion(30));
    }

    /**
     * 滚动数组
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if(n<3){
            return n;
        }

        int _1st=1,_2nd=2,r=0;
        for(int i=3;i<=n;i++){
            r=_1st+_2nd;
            _1st=_2nd;
            _2nd=r;
        }

        return r;
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs_recursion(int n){
        if(n<3){
            return n;
        }
        return climbStairs_recursion(n-1)+climbStairs_recursion(n-2);
    }
}
