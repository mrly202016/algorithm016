/**
 * 第 k 个数  https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
public class 第k个数 {
    public int getKthMagicNumber(int k) {
        int a=0,b=0,c=0;
        int[] arr=new int[k];
        arr[0]=1;
        for(int i=1;i<k;i++){
            int a_n=3*arr[a];
            int b_n=5*arr[b];
            int c_n=7*arr[c];
            int min=Math.min(Math.min(a_n,b_n),c_n);
            arr[i]=min;
            if(a_n==min){
                a++;
            }
            if(b_n==min){
                b++;
            }
            if(c_n==min){
                c++;
            }
        }
        return arr[k-1];
    }
}
