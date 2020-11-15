import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/11/12
 * Time: 17:14
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] arr=new int[]{10,80,30,90,40,50,70};
        归并排序 t=new 归并排序();
        t.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] arr,int left,int right){
        if(left>=right) return;
        int mid=(left+right)>>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right) temp[k++]=arr[i]<arr[j]?arr[i++]:arr[j++];
        while(i<=mid) temp[k++]=arr[i++];
        while(j<=right) temp[k++]=arr[j++];
        for(int p=0;p<temp.length;p++) arr[left+p]=temp[p];
    }
}
