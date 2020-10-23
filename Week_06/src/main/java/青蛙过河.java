/**
 * 青蛙过河  https://leetcode-cn.com/problems/frog-jump/
 */
public class 青蛙过河 {
    public static void main(String[] args) {
        青蛙过河 t=new 青蛙过河();
        System.out.println(t.canCross(new int[]{0,1,3,4,5,7,9,10,12}));
//        System.out.println(t.canCross(new int[]{0,1,3,5,6,8,12,17}));
//        System.out.println(t.canCross(new int[]{0,1}));
//        System.out.println(t.canCross2(new int[]{0,1}));
    }

    public boolean canCross2(int[] stones) {//DFS，这个时间超了
        if(stones[1]>1) return false;
        if(stones.length==2) return true;
        return _recursion(stones,1,1);
    }

    private boolean _recursion(int[] stones, int index, int step) {
        if(index==stones.length-1) return true;
        for(int i=index+1;i<stones.length;i++){
            int gap=stones[i]-stones[index];
            if(gap>=step-1&&gap<=step+1){
                if(_recursion(stones,i,gap)) return true;
            }
        }
        return false;
    }

    public boolean canCross(int[] stones) {
        //这里第二个数组长度设置为+1是因为最大step不可能超过stones.length，因为第一步只能是1，往后最大+1，以此类推
        boolean[][] dp=new boolean[stones.length][stones.length];
        //第一个1-代表索引下标，第二个1-代表前面的位置到达这个索引位置的步数，前面的位置不一定是前一个，也可能是前几个
        dp[1][1]=true;
        int step=0;
        for(int j=1;j<dp.length;j++){
            for(int i=0;i<j;i++){
                //当前dp[j][step]可能是由前面的dp[i][k]、dp[i][k-1]、dp[i][k+1]跳过来的
                //那么dp[j][step]能不能到达就看有没有k=step、k-1=step或k+1=step
                //也即有没有dp[i][step]、dp[i][step+1]、dp[i][step-1]能不能到达
                //再去除数组边界条件即可
                step=stones[j]-stones[i];
                if(step<=j){//第二维数组最大长度同理stones.length
                    if(step>=1) dp[j][step]=dp[j][step]||dp[i][step-1];
                    dp[j][step]=dp[j][step]||dp[i][step];
                    if(step<=j-1) dp[j][step]=dp[j][step]||dp[i][step+1];
                    if(j==stones.length-1&&dp[j][step]) return true;
                }
            }
        }
        return false;
    }
}
