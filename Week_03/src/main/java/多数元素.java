/**
 * 多数元素  https://leetcode-cn.com/problems/majority-element/description/
 */
public class 多数元素 {
    public int majorityElementVote(int[] nums) {
        int count=0;
        int candidate=0;
        for (int i:nums){
            if(count==0){
                candidate=i;
            }
            count+=candidate==i?1:-1;
        }
        return candidate;
    }

    public int majorityElement(int[] nums) {//分治
        return _recursion(nums,0,nums.length-1);
    }

    private int _recursion(int[] nums, int l, int h) {
        if(l==h){
            return nums[l];
        }

        int mid=(l+h)/2;
        int left=_recursion(nums,l,mid);
        int right=_recursion(nums,mid+1,h);

        if(left==right){
            return left;
        }

        int lc=count(nums,left);
        int hc=count(nums,right);
        return lc>hc?left:right;
    }

    private int count(int[] nums, int left) {
        int count=0;
        for(int i:nums){
            if(i==left){
                count++;
            }
        }
        return count;
    }
}
