/**
 * 戳气球  https://leetcode-cn.com/problems/burst-balloons/
 */
public class 戳气球 {
    public static void main(String[] args) {
        戳气球 t=new 戳气球();
        System.out.println(t.maxCoins(new int[]{3,1,5,8}));
    }

    public int maxCoins(int[] nums) {
        //看这个大哥的题解 https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/
        int[] pro=new int[nums.length+2];
        pro[0]=1;
        pro[pro.length-1]=1;
        for(int i=0;i<nums.length;i++) pro[i+1]=nums[i];

        int[][] dp=new int[pro.length][pro.length];
        //注意i<j，并且根据二维图，发现dp[i][j]要先求出左边和下边的值，也就是要从下到上，从左到右到遍历
        for(int j=2;j<dp.length;j++){
            for(int i=dp.length;i>=0;i--){
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+pro[i]*pro[k]*pro[j]+dp[k][j]);
                }
            }
        }

        return dp[0][dp.length-1];
    }
}
