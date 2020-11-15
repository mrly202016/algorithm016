import java.util.Arrays;

/**
 * 翻转对  https://leetcode-cn.com/problems/reverse-pairs/
 */
public class 翻转对 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,2,3,1};
        翻转对 t=new 翻转对();
        t.reversePairs(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int reversePairs(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=(left+right)>>>1;
        int count=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);
//        count+=merge(nums,left,mid,right);
        count+=merge2(nums,left,mid,right);
        return count;
    }

    private int merge2(int[] nums, int left, int mid, int right) {//这个在一个循环中完成效率高
        int[] temp=new int[right-left+1];
        int i=left,k=0,l=left,count=0;
        for(int r=mid+1;r<=right;r++){
            while(l<=mid&&nums[l]<=(long)2*nums[r]) l++;
            while(i<=mid&&nums[i]<nums[r]) temp[k++]=nums[i++];
            temp[k++]=nums[r];
            count+=mid-l+1;
        }
        while(i<=mid) temp[k++]=nums[i++];
        System.arraycopy(temp,0,nums,left,temp.length);
        return count;
    }

    private int merge(int[] nums, int left, int mid, int right) {//这个分2次循环好理解
        int[] temp=new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right){
            temp[k++]=nums[i]<nums[j]?nums[i++]:nums[j++];
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=right) temp[k++]=nums[j++];
        int l=left,count=0;
        for(int r=mid+1;r<=right;r++){
            while(l<=mid&&nums[l]<=(long)2*nums[r]) l++;
            count+=mid-l+1;
        }
        System.arraycopy(temp,0,nums,left,temp.length);
        return count;
    }
}
