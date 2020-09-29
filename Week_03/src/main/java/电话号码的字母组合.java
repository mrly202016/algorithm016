import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder path=new StringBuilder();
        dfs(digits,0,path,map,list);
        return list;
    }

    private void dfs(String digits, int depth, StringBuilder path, Map<Character, String> map, List<String> list) {
        if(depth==digits.length()){
            list.add(path.toString());
            return;
        }
        String value=map.get(digits.charAt(depth));
        for(int j=0;j<value.length();j++){
            path.append(value.charAt(j));
            dfs(digits,depth+1,path,map,list);
            path.deleteCharAt(depth);
        }
    }
}
