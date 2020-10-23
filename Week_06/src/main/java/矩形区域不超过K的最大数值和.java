import java.util.TreeSet;

/**
 * 矩形区域不超过 K 的最大数值和  https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class 矩形区域不超过K的最大数值和 {
    public static void main(String[] args) {
        矩形区域不超过K的最大数值和 t=new 矩形区域不超过K的最大数值和();
        System.out.println(t.maxSumSubmatrix3(new int[][]{{1,0,1},{0,-2,3}}, 2));
    }

    public int maxSumSubmatrix3(int[][] matrix, int k) {//前缀和
        int row=matrix.length,col=matrix[0].length;
        int[] rowSum=null;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int l=0;l<col;l++){
            rowSum=new int[row];
            for(int r=l;r<col;r++){
                for(int i=0;i<row;i++){
                    rowSum[i]+=matrix[i][r];
                }

                TreeSet<Integer> set=new TreeSet<>();
                //初始化，避免漏掉sum=k的情况
                set.add(0);
                //前缀和
                sum=0;
                for(int m=0;m<row;m++){
                    sum+=rowSum[m];
                    Integer minGe=set.ceiling(sum-k);//获取大于等于sum-k的最小值，当sum固定的时候，前缀和越小越好
                    if(minGe!=null) max=Math.max(max,sum-minGe);
                    if(max==k) return k;
                    set.add(sum);
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {//极端情况下的优化
        int row=matrix.length,col=matrix[0].length;
        int[] rowSum=null;
        int max=Integer.MIN_VALUE;
        int max_max=0;
        int sum=0;
        for(int l=0;l<col;l++){
            rowSum=new int[row];
            for(int r=l;r<col;r++){
                for(int i=0;i<row;i++){
                    rowSum[i]+=matrix[i][r];
                }

                //假设每一轮max<=k的情况下，以求最大子序和的方式，只一层循环算出最接近k的值
                sum=rowSum[0];
                max_max=rowSum[0];
                for(int p=1;p<row;p++){
                    sum=sum>=0?sum+rowSum[p]:rowSum[p];
                    max_max=Math.max(sum,max_max);
                }
                if(max_max<=k){
                    max=Math.max(max,max_max);
                    if(max==k) return k;
                    continue;
                }

                for(int m=0;m<row;m++){
                    sum=0;
                    for(int n=m;n<row;n++){
                        sum+=rowSum[n];
                        if(sum<=k) max=Math.max(max,sum);
                        if(max==k) return k;
                    }
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        //看这个大哥的题解 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
        int row=matrix.length,col=matrix[0].length;
        int[] rowSum=new int[row];
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int l=0;l<col;l++){
            rowSum=new int[row];
            for(int r=l;r<col;r++){
                for(int i=0;i<row;i++){
                    rowSum[i]+=matrix[i][r];
                }

                for(int m=0;m<row;m++){
                    sum=0;
                    for(int n=m;n<row;n++){
                        sum+=rowSum[n];
                        if(sum<=k) max=Math.max(max,sum);
                        if(max==k) return k;
                    }
                }
            }
        }
        return max;
    }
}
