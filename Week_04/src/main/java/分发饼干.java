import java.util.Arrays;

/**
 * 分发饼干 https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class 分发饼干 {
    public int findContentChildren_Upgrade(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,sj=0;
        while (gi<g.length&&sj<s.length){
            if(g[gi]<=s[sj]) gi++;
            sj++;
        }
        return gi;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int j=0;
        for(int i=0;i<g.length;i++){
            while (j<s.length){
                if(s[j]>=g[i]){
                    j++;
                    count++;
                    break;
                }
                j++;
            }
        }
        return count;
    }
}
