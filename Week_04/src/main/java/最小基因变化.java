import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 最小基因变化 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class 最小基因变化 {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for(String b:bank){
            bankSet.add(b);
        }

        char[] swapChars=new char[]{'A','C','G','T'};
        Set<String> visited = new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int level=0;

        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                String cur=queue.poll();
                if(cur.equals(end)){
                    return level;
                }

                //https://leetcode.com/problems/minimum-genetic-mutation/discuss/91484/Java-Solution-using-BFS
                //这块逻辑想了很久，不太好理解。其实是要把它想象成一颗树，一个字符串的每一个字符都可以选择改变一次，
                //而改变一次又有4种改法，也就是4*字符串长度的平行改法都可以加入queue，这算一层。
                // 但要去重，没有被采取过的改变方式并且在bank库中的才可以加入queue
                //值到某一个字符串等于了最终的end，就返回层级
                char[] chars=cur.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char old=chars[i];
                    for(char c:swapChars){
                        chars[i]=c;
                        String ns=new String(chars);
                        if(!visited.contains(ns)&&bankSet.contains(ns)){
                            queue.offer(ns);
                            visited.add(ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }

        return -1;

    }
}
