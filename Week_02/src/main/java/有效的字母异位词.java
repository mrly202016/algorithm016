import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode做题-有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/description/https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class 有效的字母异位词 {
    public static boolean isAnagramMap(String s, String t) {
        Map map=new HashMap();
        int count=0;

        for(int i=0;i<s.length();i++){
            if((int)map.getOrDefault(s.charAt(i),0)<0){
                count++;
            }
            map.put(s.charAt(i),(int)map.getOrDefault(s.charAt(i),0)+1);
            if(i>=t.length()){
                return false;
            }
            if((int)map.getOrDefault(t.charAt(i),0)>0){
                count++;
            }
            map.put(t.charAt(i),(int)map.getOrDefault(t.charAt(i),0)-1);
        }

        return count==s.length()&&count==t.length();
    }

    public boolean isAnagramArr(String s, String t) {
        int count=0;
        int[] nums=new int[26];

        for(int i=0;i<s.length();i++){
            if(nums[s.charAt(i)-'a']++<0) count++;
            if(i>=t.length()){
                return false;
            }
            if(nums[t.charAt(i)-'a']-->0) count++;
        }

        return count==s.length()&&count==t.length();
    }
}
