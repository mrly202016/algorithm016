/**
 * Leetcode做题-三步问题 https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class 三步问题 {
    public int waysToStep(int n) {
        if(n<3){
            return n;
        }
        if(n==3){
            return 4;
        }

        int _1st=1,_2nd=2,_3rd=4,cur=0;
        for(int i=4;i<=n;i++){
            //前2个数相加可能越界，所以取模，取模之后加第三个数还可能越界，所以再取模
            cur=((_1st+_2nd)%1000000007+_3rd)%1000000007;
            _1st=_2nd;
            _2nd=_3rd;
            _3rd=cur;
        }
        return cur;
    }
}
