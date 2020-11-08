import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/11/8
 * Time: 21:50
 */
public class 快速排序 {
    public static void main(String[] args) {
        快速排序 t=new 快速排序();
        int[] arr=new int[]{10,80,30,90,40,50,70};
        t.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] arr,int begin,int end){
        //比如当pivot=1，end=1的时候，pivot左边0到pivot-1是begin=end，没问题
        //但是pivot右边，也就是pivot+1=2,到end=1,就出现了begin>end，所以判断退出的条件是begin>=end，而不只是begin=end
        if(begin>=end) return;
        int pivot=partition(arr,begin,end);
        quickSort(arr,begin,pivot-1);
        quickSort(arr,pivot+1,end);
    }

    private int partition(int[] arr, int begin, int end) {
        //整体思想是，遍历begin到end（这里假定pivot是end）,index记录小于pivot元素的位置
        // 遇到小于pivot的元素，就将遍历到的i位置的元素放到index处，将index处的元素放到i处，就相当于交换
        int pivot=end;
        int index=begin;//index是下一个小于a[pivot]的元素可以放置的位置
        for(int i=begin;i<end;i++){
            if(arr[i]<arr[pivot]){
                int temp=arr[i];arr[i]=arr[index];arr[index]=temp;
                index++;
            }
        }
        //当i遍历结束，此时还剩一个pivot的元素，此时index位置处的元素肯定是大于等于pivot的
        // 因为小于pivot的都已经交换过去了
        //所以最后交换pivot和index处的元素，下一个标杆的位置就是
        int temp=arr[pivot];arr[pivot]=arr[index];arr[index]=temp;
        System.out.println(Arrays.toString(arr));
        return index;
    }
}
