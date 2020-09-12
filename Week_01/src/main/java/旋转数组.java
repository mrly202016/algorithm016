/**
 * leetcode做题-旋转数组  https://leetcode-cn.com/problems/rotate-array/
 */
public class 旋转数组 {
    public void rotateReverse(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int first, int last) {
        while (first<last){
            int temp=nums[first];
            nums[first]=nums[last];
            nums[last]=temp;
            first++;
            last--;
        }
    }

    public void rotateAdditionArr(int[] nums, int k) {
        k=k%nums.length;
        int[] arr=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length]=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }

    }

    public void rotateDoubleLoop(int[] nums, int k) {
        k=k%nums.length;
        for (int j=0;j<k;j++){
            int prev=nums[nums.length-1];
            for (int i = 0; i < nums.length; i++) {
                int tmp=nums[i];
                nums[i]=prev;
                prev=tmp;
            }
        }
    }

    public void rotate_recursion(int[] nums, int k) {
        k=k%nums.length;
        while (k>=1){
            _recursion(nums,nums[nums.length-1],0);
            k--;
        }
    }

    private void _recursion(int[] nums, int prev, int i) {
        if(i>=nums.length){
            return;
        }
        int temp=nums[i];
        nums[i]=prev;
        prev=temp;
        _recursion(nums,prev,i+1);
    }
}
