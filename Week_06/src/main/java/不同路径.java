import java.util.Arrays;

/**
 * 不同路径  https://leetcode-cn.com/problems/unique-paths/
 */
public class 不同路径 {
    public static void main(String[] args) {
        不同路径 t=new 不同路径();
//        System.out.println(t.uniquePaths(51,9));
        System.out.println(t.uniquePaths_loop(51,9));
        System.out.println(t.uniquePaths_loop2(51,9));
        System.out.println(t.uniquePaths_loop3(51,9));
    }

    public int uniquePaths_loop3(int m, int n) {//优化3
        int[] cur=new int[n];
        Arrays.fill(cur,1);
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                    //从uniquePaths_loop2转化得来，pre就相当于前一个cur
                cur[j]=cur[j]+cur[j+1];
            }
        }
        return cur[0];
    }

    public int uniquePaths_loop2(int m, int n) {//优化2
        //前一行用pre表示，列用n来计数
        int[] pre=new int[n];
        int[] cur=new int[n];
        Arrays.fill(pre,1);
        Arrays.fill(cur,1);
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                //6-start,x-end
                //6  3  1
                //3  2  1(y)
                //1  1(z)  x
                //以2为例，2的值等于同一列(j)之前一行(pre)的z,加上同一行(cur)之后一列(j+1)的y
                cur[j]=pre[j]+cur[j+1];
            }
            pre=cur;
        }
        return cur[0];
    }

    public int uniquePaths_loop(int m, int n) {//自下而上loop
        int[][] cells=new int[m][n];
        for(int i=0;i<m;i++) cells[i][n-1]=1;
        for(int j=0;j<n;j++) cells[m-1][j]=1;

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                cells[i][j]=cells[i+1][j]+cells[i][j+1];
            }
        }
        return cells[0][0];
    }

    public int uniquePaths(int m, int n) {//自上而下递归
        return m==1||n==1?1:_recursion(m-1,n)+_recursion(m,n-1);
    }

    private int _recursion(int row, int col) {
        if(row==1){
            return 1;
        }
        if(col==1){
            return 1;
        }
        return _recursion(row-1,col)+_recursion(row,col-1);
    }
}
