import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和 https://leetcode-cn.com/problems/triangle/description/
 */
public class 三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3,4}));
        triangle.add(Arrays.asList(new Integer[]{6,5,7}));
        triangle.add(Arrays.asList(new Integer[]{4,1,8,3}));
        三角形最小路径和 t=new 三角形最小路径和();
        t.minimumTotal5(triangle);

    }

    public int minimumTotal5(List<List<Integer>> triangle) {//推荐
        int m=triangle.size();
        int[] cur=new int[m+1];//行数和列数相同，+1是为了多最后一行，以便在循环中不用为最后一行判断赋值
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<=i;j++){//这个地方要注意，j最大是所在行的行数，不是m-1
                cur[j]=Math.min(cur[j],cur[j+1])+triangle.get(i).get(j);
            }
        }
        return cur[0];
    }

    public int minimumTotal4(List<List<Integer>> triangle) {//空间优化，速度不及minimumTotal3()
        int m=triangle.size();
        int temp=0;
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                temp=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j);
                triangle.get(i).set(j,temp);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {//优化
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int[] cur=new int[n];
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==m-1){
                    cur[j]=triangle.get(i).get(j);
                }else {
                    cur[j]=Math.min(cur[j],cur[j+1])+triangle.get(i).get(j);
                }
            }
        }
        return cur[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {//loop
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int[][] dp=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                if(i==m-1){
                    dp[i][j]=triangle.get(i).get(j);
                }else {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }

    public int minimumTotal_memo(List<List<Integer>> triangle) {//递归+记忆化
        //列数和行数相同
        int[][] memo=new int[triangle.size()][triangle.size()];
        return _recusrionMemo(0,0,memo,triangle);
    }

    private int _recusrionMemo(int level, int index, int[][] memo, List<List<Integer>> triangle) {
        if(level==triangle.size()){
            return 0;
        }
        if(memo[level][index]!=0){
            return memo[level][index];
        }
        int l=_recusrionMemo(level+1,index,memo,triangle);
        int r=_recusrionMemo(level+1,index+1,memo,triangle);
        return Math.min(l,r)+triangle.get(level).get(index);
    }

    public int minimumTotal(List<List<Integer>> triangle) {//递归，分治
        return _recusrion(0,0,triangle);
    }

    private int _recusrion(int level, int index, List<List<Integer>> triangle) {
        if(level==triangle.size()-1){
            return triangle.get(level).get(index);
        }
        int l=_recusrion(level+1,index,triangle);
        int r=_recusrion(level+1,index+1,triangle);
        return Math.min(l,r)+triangle.get(level).get(index);
    }
}
