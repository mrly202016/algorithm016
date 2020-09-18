import java.util.Arrays;

/**
 * 堆排
 */
public class 堆排 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        sort(arr);
    }

    static void sort(int[] arr){
        int n=arr.length;

        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("**********************");

        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;

            heapify(arr,i,0);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int n, int i) {
        int max=i;
        int l=2*i+1;
        int r=2*i+2;

        if(l<n&&arr[l]>arr[max]){
            max=l;
        }

        if(r<n&&arr[r]>arr[max]){
            max=r;
        }

        if(max!=i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;

            heapify(arr,n,max);
        }
    }
}
