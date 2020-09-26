/**
 * 爬楼梯0922
 */
public class 爬楼梯0922 {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int _1st=1,_2nd=2,cur=0;
        for(int i=3;i<=n;i++){
            cur=_1st+_2nd;
            _1st=_2nd;
            _2nd=cur;
        }
        return cur;
    }
}
