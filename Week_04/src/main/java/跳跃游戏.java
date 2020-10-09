/**
 * 跳跃游戏  https://leetcode-cn.com/problems/jump-game/
 */
public class 跳跃游戏 {
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
