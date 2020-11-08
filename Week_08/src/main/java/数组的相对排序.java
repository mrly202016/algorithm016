import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/11/7
 * Time: 18:09
 */
public class 数组的相对排序 {
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {//如果阿柔软arr1中数字之间差距非常大，那么这个可能更通用
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++) map.put(arr2[i],i);
        quickSort(arr1,0,arr1.length-1,map);
        return arr1;
    }

    private void quickSort(int[] arr, int begin, int end, Map<Integer, Integer> map) {
        if(begin>=end) return;
        int pivot=partition(arr,begin,end,map);
        quickSort(arr,begin,pivot-1,map);
        quickSort(arr,pivot+1,end,map);
    }

    private int partition(int[] arr, int begin, int end, Map<Integer, Integer> map) {
        int pivot=end;
        int index=begin;
        for(int i=begin;i<end;i++){
            if(compareLess(arr[i],arr[pivot],map)){
                int temp=arr[i];arr[i]=arr[index];arr[index]=temp;
                index++;
            }
        }
        int temp=arr[pivot];arr[pivot]=arr[index];arr[index]=temp;
        return index;
    }

    private boolean compareLess(int loopElement, int pivotElement, Map<Integer, Integer> map) {
        if(map.containsKey(loopElement)&&map.containsKey(pivotElement)){
            //2个元素都在arr2中，就比较下标，下标小的放在pivot左边，大的放右边
            return map.get(loopElement)<map.get(pivotElement);
        }else if(map.containsKey(loopElement)){
            //pivot元素下标不存在，说明arr2中不包含pivot元素，说明loopElement元素就应该在pivot左边，也就是前面
            return true;
        }else if(map.containsKey(pivotElement)){
            //loopElement元素下标不存在，说明arr2中不包含loopElement元素，loopElement元素应该放到后面去，也就是放到pivot右边
            return false;
        }else {
            //2个元素都不在arr2中，直接正常比较大小
            return loopElement<pivotElement;
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter=new int[1001];
        for(int n:arr1) counter[n]++;

        int i=0;
        for(int n:arr2){
            while(counter[n]>0){
                arr1[i++]=n;
                counter[n]--;
            }
        }

        for(int k=0;k<counter.length;k++){
            while(counter[k]>0){
                arr1[i++]=k;
                counter[k]--;
            }
        }
        return arr1;
    }
}
