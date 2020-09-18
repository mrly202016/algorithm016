import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode做题-FizzBuzz https://leetcode-cn.com/problems/fizz-buzz/
 */
public class FizzBuzz {
    public List<String> fizzBuzzNormalMap(int n) {//官网里第三种解法，更通用
        Map<Integer,String> map=new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        List<String> list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            String str="";
            for(Integer key:map.keySet()){
                if(i%key==0){
                    str+=map.get(key);
                }
            }
            if("".equals(str)){
                str+=i;
            }
            list.add(str);
        }
        return list;
    }

    public List<String> fizzBuzzNormalGrace(int n) {//官网里这种解法是为了防止再增加个7，9什么的，需要组合的判断就会减少
        List<String> list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            String str="";
            if(i%3==0){
                str+="Fizz";
            }
            if(i%5==0){
                str+="Buzz";
            }
            if("".equals(str)){
                str+=i;
            }
            list.add(str);
        }
        return list;
    }

    public List<String> fizzBuzzNormal(int n) {//普通解法
        List<String> list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            if(i%15==0){
                list.add("FizzBuzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else if(i%5==0){
                list.add("Buzz");
            }else {
                list.add(i+"");
            }
        }
        return list;
    }
}
