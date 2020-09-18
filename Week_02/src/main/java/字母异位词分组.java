import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode做题-字母异位词分组  https://leetcode-cn.com/problems/group-anagrams/
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String s:strs){
            char[] chars=new char[26];
            for(char c:s.toCharArray()){
                chars[c-'a']++;
            }
            String t=String.valueOf(chars);
            if(!map.containsKey(t)){
                map.put(t,new ArrayList<>());
            }
            map.get(t).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
