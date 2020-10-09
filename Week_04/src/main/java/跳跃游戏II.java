/**
 * 跳跃游戏 II  https://leetcode-cn.com/problems/jump-game-ii/
 */
public class 跳跃游戏II {
    public int jump2(int[] nums) {
        int count=0,end=0,max=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,i+nums[i]);
            if(i==end){
                end=max;
                count++;
            }
        }
        return count;
    }

    public int jump(int[] nums) {
        int index=nums.length-1;
        int count=0;
        while (index>0){
            for (int i=0;i<=index;i++){
                if(i+nums[i]>=index){
                    index=i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
