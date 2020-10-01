import java.util.*;

/**
 * 单词接龙  https://leetcode-cn.com/problems/word-ladder/
 */
public class 单词接龙 {
    public int ladderLength_BFS_Two_End_Upgrade_Twice(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        int len=beginWord.length();

        Queue<String> begin=new LinkedList<>();
        Set<String> b_visited=new HashSet<>();
        begin.offer(beginWord);
        b_visited.add(beginWord);

        Queue<String> end=new LinkedList<>();
        Set<String> e_visited=new HashSet<>();
        end.offer(endWord);
        e_visited.add(endWord);

        return bfs(len,0,begin,b_visited,end,e_visited,wordSet);
    }

    private int bfs(int len,int level, Queue<String> begin, Set<String> b_visited, Queue<String> end, Set<String> e_visited, Set<String> wordSet) {
        while (!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                return bfs(len,level,end,e_visited,begin,b_visited,wordSet);
            }
            int size=begin.size();
            while (size-->0){
                String cur=begin.poll();
                char[] chars=cur.toCharArray();
                for (int i=0;i<len;i++){
                    char old=chars[i];
                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String ns=new String(chars);
                        if(e_visited.contains(ns)){
                            return level+2;
                        }
                        if(!b_visited.contains(ns)&&wordSet.contains(ns)){
                            begin.offer(ns);
                            b_visited.add(ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }

        return 0;
    }

    public int ladderLength_BFS_Two_End_Upgrade(String beginWord, String endWord, List<String> wordList) {
        //这是对ladderLength_BFS_Two_End()的优化
        //建议不要把单词变成通配符存字典，如果按一个通配符存一个单词来记，最后字典里存的单词数量是wordList单词数量x单词长度的倍数，直接把wordList存到set判断单词是否存在
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        int len=beginWord.length();

        Queue<String> begin=new LinkedList<>();
        Set<String> b_visited=new HashSet<>();
        begin.offer(beginWord);
        b_visited.add(beginWord);

        Queue<String> end=new LinkedList<>();
        Set<String> e_visited=new HashSet<>();
        end.offer(endWord);
        e_visited.add(endWord);

        int level=0;

        while (!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                Queue<String> temp=begin;
                begin=end;
                end=temp;
                Set<String> temp_v=b_visited;
                b_visited=e_visited;
                e_visited=temp_v;
            }
            int size=begin.size();
            while (size-->0){
                String cur=begin.poll();
                char[] chars=cur.toCharArray();
                for (int i=0;i<len;i++){
                    char old=chars[i];
                    for(char c='a';c<='z';c++){
                        chars[i]=c;
                        String ns=new String(chars);
                        if(e_visited.contains(ns)){
                            return level+2;
                        }
                        if(!b_visited.contains(ns)&&wordSet.contains(ns)){
                            begin.offer(ns);
                            b_visited.add(ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }

        return 0;
    }

    public int ladderLength_BFS_Two_End(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int len=beginWord.length();
        Map<String,Set<String>> dictMap=new HashMap<>();
        wordList.forEach(x->{
            for(int i=0;i<len;i++){
                String generic=x.substring(0,i)+"*"+x.substring(i+1,len);
                if(dictMap.get(generic)==null){
                    dictMap.put(generic,new HashSet<>());
                }
                dictMap.get(generic).add(x);
            }
        });

        Queue<String> begin=new LinkedList<>();
        Set<String> b_visited=new HashSet<>();
        begin.offer(beginWord);
        b_visited.add(beginWord);

        Queue<String> end=new LinkedList<>();
        Set<String> e_visited=new HashSet<>();
        end.offer(endWord);
        e_visited.add(endWord);

        int level=0;

        while (!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                Queue<String> temp=begin;
                begin=end;
                end=temp;
                Set<String> temp_v=b_visited;
                b_visited=e_visited;
                e_visited=temp_v;
            }
            int size=begin.size();
            while (size-->0){
                String cur=begin.poll();
                for (int i=0;i<len;i++){
                    String generic=cur.substring(0,i)+"*"+cur.substring(i+1,len);
                    if(dictMap.get(generic)!=null){
                        for(String word:dictMap.get(generic)){
                            if(e_visited.contains(word)){
                                return level+2;
                            }
                            if(!b_visited.contains(word)){
                                begin.offer(word);
                                b_visited.add(word);
                            }
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public int ladderLength_BFS_Upgrade(String beginWord, String endWord, List<String> wordList) {
        int len=beginWord.length();
        Map<String,List<String>> dictMap=new HashMap<>();
        wordList.forEach(x->{
            for(int i=0;i<len;i++){
                String generic=x.substring(0,i)+"*"+x.substring(i+1,len);
                if(dictMap.get(generic)==null){
                    dictMap.put(generic,new ArrayList<>());
                }
                dictMap.get(generic).add(x);
            }
        });

        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level=0;

        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                String cur=queue.poll();
                if(cur.equals(endWord)){
                    return level+1;
                }
                for(int i=0;i<len;i++){
                    String generic=cur.substring(0,i)+"*"+cur.substring(i+1,len);
                    if(dictMap.get(generic)!=null){
                        for(String word:dictMap.get(generic)){
                            if(!visited.contains(word)){
                                queue.offer(word);
                                visited.add(word);
                            }
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {//这个解法是最小基因的解法
        Set<String> wordSet=new HashSet<>(wordList);//这步优化很关键，List.contains是O(n)的，Set.contains是O(1)，最差O(n)
        Set<String> visited=new HashSet<>();
        char[] swapChar=new char[26];
        for(int i=0;i<swapChar.length;i++){
            swapChar[i]= (char) ('a'+i);
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                String cur=queue.poll();
                if(cur.equals(endWord)){
                    return level+1;
                }

                char[] chars=cur.toCharArray();
                for (int i=0;i<chars.length;i++){
                    char old=chars[i];
                    for(char c:swapChar){
                        chars[i]=c;
                        String ns=new String(chars);
                        if(!visited.contains(ns)&&wordSet.contains(ns)){
                            queue.offer(ns);
                            visited.add(ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            level++;
        }
        return 0;
    }
}
