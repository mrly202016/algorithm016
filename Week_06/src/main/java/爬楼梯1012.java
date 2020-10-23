/**
 * 爬楼梯
 */
public class 爬楼梯1012 {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int _1st=1,_2st=2,cur=0;
        for(int i=3;i<=n;i++){
            cur=_1st+_2st;
            _1st=_2st;
            _2st=cur;
        }
        return cur;
    }
}
