/**
 * 搜索旋转排序数组  https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class 搜索旋转排序数组 {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int l=0,r=nums.length-1,mid=0;
        while (l<=r){
            mid=(l+r)>>>1;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]){//看mid是不是严格在左边的有序数组中
                if(target>=nums[l]&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {//看mid是不是严格在右边的有序数组中
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
