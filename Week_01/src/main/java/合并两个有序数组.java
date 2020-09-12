/**
 * leetcode做题-合并两个有序数组  https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m>=1&&n>=1){
            nums1[m+n-1]=nums1[m-1]>nums2[n-1]?nums1[(m--)-1]:nums2[(n--)-1];
        }

        while (n>0){
            nums1[n-1]=nums2[n-1];
            n--;
        }
    }
}
