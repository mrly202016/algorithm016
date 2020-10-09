/**
 * 寻找旋转排序数组中的最小值  https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class 寻找旋转排序数组中的最小值 {
    public int findMin2(int[] nums) {//推荐
        int l=0,r=nums.length-1,mid=0;
        while (l<r){
            mid=(l+r)>>>1;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return nums[l];
    }


    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }

        int l=0,r=nums.length-1,mid=0;
        while (l<=r){
            mid=(l+r)>>>1;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[l]<nums[mid]){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return -1;
    }
}
