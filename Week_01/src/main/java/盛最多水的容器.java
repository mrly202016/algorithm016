/**
 * leetcode做题-盛最多水的容器  https://leetcode-cn.com/problems/container-with-most-water/
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,max=0;
        while (l<r){
            max=Math.max(max,(r-l)*Math.min(height[l],height[r]));//面积由矮边决定
            /**
             * 双指针法：关键是什么时候移动指针
             *
             * 1、如果移动高的一边，那么首先宽度变窄了，下一个边会出现3种情况：
             * 比不动的矮边高：面积变小
             * 等于不动的矮边：面积变小
             * 比不动的矮边低：面积变小
             *
             * 2、如果移动矮的一边，那么首先宽度变窄了，下一个边会出现3种情况：
             * 比不动的高边高：面积可能变大也可能变小，也可能不变
             * 等于不动的高边：面积可能变大也可能变小，也可能不变
             * 比不动的高边低：面积可能变大也可能变小，也可能不变
             *
             * 所以只有移动矮边，面积才有可能变大，移动高边，面积永远都是变小
             */
            if(height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }
        return max;
    }
}
