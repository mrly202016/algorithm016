/**
 * Created by IntelliJ IDEA
 * User: yyzz
 * Date: 2020/9/7
 * Time: 22:26
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        int j=0;//处于最前面位置的0的指针
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(i>j){//针对一开始不为0的情况，不为0就不需要对换，
                    nums[j]=nums[i];
                    nums[i]=0;
                }
                j++;//初始位置不为0时，指针也需要后移
            }
        }
    }
}
