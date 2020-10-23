/**
 * 跳跃游戏  https://leetcode-cn.com/problems/jump-game/
 */
public class 跳跃游戏 {
    public boolean canJump2(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i>max) return false;
            max=Math.max(max,nums[i]+i);
            if(max>=nums.length-1) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(max>=i){
                max=Math.max(max,i+nums[i]);
                if(max>=nums.length-1){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }
}
