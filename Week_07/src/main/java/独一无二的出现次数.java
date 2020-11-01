import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 独一无二的出现次数  https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class 独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap();
        for(int n:arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        Set<Integer> set=new HashSet<>();
        for(Integer n:map.values()){
            if(!set.add(n)) return false;
        }
        return true;
    }
}
