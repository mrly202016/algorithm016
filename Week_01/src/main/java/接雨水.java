import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode做题-接雨水  https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class 接雨水 {
    public int trapDoublePointer(int[] height) {
        int total=0;
        int l=0,r=height.length-1;
        int lmax=0,rmax=0;

        while (l<r){
            if(height[l]<height[r]){
                if(height[l]<=lmax){
                    total+=lmax-height[l];
                }else {
                    lmax=height[l];
                }
                l++;
            }else {
                if(height[r]<=rmax){
                    total+=rmax-height[r];
                }else {
                    rmax=height[r];
                }
                r--;
            }
        }

        return total;
    }

    public int trapStack(int[] height) {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(-1);
        int total=0;

        for(int i=0;i<height.length;i++){
            while (stack.peek()!=-1&&height[i]>height[stack.peek()]){
                int bottom=height[stack.pop()];
                if(stack.peek()==-1){
                    break;
                }
                total+=(Math.min(height[stack.peek()],height[i])-bottom)*(i-stack.peek()-1);
            }
            stack.push(i);
        }

        return total;
    }
}
