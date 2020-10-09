import java.util.HashSet;
import java.util.Set;

/**
 * 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/description/
 */
public class 模拟行走机器人 {
    public int robotSim_Int(int[] commands, int[][] obstacles) {//推荐
        //上北下南，左西右东，顺时针方向
        int[] dx=new int[]{0,1,0,-1};
        int[] dy=new int[]{1,0,-1,0};
        int x=0,y=0,di=0;
        Set<Integer> set=new HashSet<>();
        for(int[] obs:obstacles){//把坐标存set，根据范围放int的高16和低16，确保唯一
            int ox = obs[0] + 30000;
            int oy = obs[1] + 30000;
            set.add((ox << 16) + oy);
        }

        int max=0;
        for(int c:commands){
            if(c==-1){
                di=(di+1)%4;//向右90度
            }else if(c==-2){
                di=(di+3)%4;//向左90度
            }else {
                for(int i=0;i<c;i++){//根据步长一个个验证
                    int nx=x+dx[di];
                    int ny=y+dy[di];
                    int code=((nx + 30000) << 16)+ny + 30000;
                    if(!set.contains(code)){
                        x=nx;
                        y=ny;
                        max=Math.max(max,x*x+y*y);
                    }else {
                        break;
                    }
                }
            }
        }
        return max;
    }

    public int robotSim_Str(int[] commands, int[][] obstacles) {
        int[] dx=new int[]{0,1,0,-1};
        int[] dy=new int[]{1,0,-1,0};
        int x=0,y=0,di=0;
        Set<String> set=new HashSet<>();
        for(int[] obs:obstacles){
            set.add(obs[0]+" "+obs[1]);
        }

        int max=0;
        for(int c:commands){
            if(c==-1){
                di=(di+1)%4;
            }else if(c==-2){
                di=(di+3)%4;
            }else {
                for(int i=0;i<c;i++){
                    int nx=x+dx[di];
                    int ny=y+dy[di];
                    if(!set.contains(nx+" "+ny)){
                        x=nx;
                        y=ny;
                        max=Math.max(max,x*x+y*y);
                    }
                }
            }
        }
        return max;
    }
}
