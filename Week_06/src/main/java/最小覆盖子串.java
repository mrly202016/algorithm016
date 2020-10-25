import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串  https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        最小覆盖子串 t=new 最小覆盖子串();
        System.out.println(t.minWindow("cabwefgewcwaefgcf","cae"));
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int l=0,r=0,begin=0;
        int count=t.length();
        int dist=Integer.MAX_VALUE;
        char c=0;
        Integer ci=null;

        //分别设置左指针和右指针，右指针先移动，直到覆盖全部字符，这时候开始移动左指针，将左指针移动到边界，即左指针再往后移动，区间内的字符就不能覆盖全了。这时候再从头开始重复
        //注意点：
        //（1）移动右指针的过程中，遇到与t中字符重复的字符，那么需要将计数再-1
        //（2）移动左指针的过程中，有种情况可以移动：遇到不在t中的字符，t中字符计数<0的（小于0是因为前面右指针移动过程中，遇到与t中相同的字符会多减）
        //到达边界时，记录区间长度，同时，将左指针向后移动一个，那么此时区间内字符串就不完整了，count+1，继续从头开始
        while(r<s.length()){
            c=s.charAt(r++);
            ci=map.get(c);
            if(ci!=null){
                map.put(c,ci-1);
                if(ci>0)  count--;//大于0的时候count-1，小于0表示重复了，字符计数可以多减，但count不能再减
            }
            while(count==0){
                c=s.charAt(l);
                ci=map.get(c);
                if(ci==null||ci<0) {
                    l++;
                    if(ci!=null) map.put(c,ci+1);
                    continue;
                }
                if(r-l<dist){
                    dist=r-l;
                    begin=l;
                }
                l++;
                count++;
                map.put(c,1);
            }
        }

        return dist==Integer.MAX_VALUE?"":s.substring(begin,begin+dist);
    }
}
