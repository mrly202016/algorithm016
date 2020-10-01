import java.util.*;

/**
 * 单词接龙 II  https://leetcode-cn.com/problems/word-ladder-ii/description/
 */
public class 单词接龙II {
    //https://leetcode-cn.com/problems/word-ladder-ii/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you--2/
    //先看懂上面这个题解链接

    public List<List<String>> findLadders_Two_End(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists=new ArrayList<>();
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return lists;
        }
        int len=beginWord.length();

        Map<String,List<String>> map=new HashMap<>();

        Queue<String> begin=new LinkedList<>();
        Set<String> b_visited=new HashSet<>();
        begin.offer(beginWord);
        b_visited.add(beginWord);

        Queue<String> end=new LinkedList<>();
        Set<String> e_visited=new HashSet<>();
        end.offer(endWord);
        e_visited.add(endWord);

        boolean possible=false;
        boolean swap=false;
        Set<String> nextLevelVisited=new HashSet<>();

        while (!begin.isEmpty()&&!end.isEmpty()){
            if(begin.size()>end.size()){
                Queue<String> temp=begin;
                begin=end;
                end=temp;
                Set<String> temp_v=b_visited;
                b_visited=e_visited;
                e_visited=temp_v;
                swap=!swap;
            }
            int size=begin.size();
            while (size-->0){
                String cur=begin.poll();
                char[] chars=cur.toCharArray();
                for (int i=0;i<len;i++){
                    char old=chars[i];
                    for(char c='a';c<='z';c++){
                        if(c==old){
                            continue;
                        }
                        chars[i]=c;
                        String ns=new String(chars);
                        if(e_visited.contains(ns)){
                            possible=true;
                        }
                        if(!b_visited.contains(ns)&&wordSet.contains(ns)){
                            if(!nextLevelVisited.contains(ns)){
                                begin.offer(ns);
                                nextLevelVisited.add(ns);
                            }
                            addToMap(map,swap,cur,ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            if(possible){
                break;
            }
            b_visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }

        if(!possible){
            return lists;
        }

        Deque<String> path=new LinkedList<>();
        path.addLast(beginWord);
        dfs(beginWord,endWord,path,map,lists);

        return lists;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists=new ArrayList<>();
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return lists;
        }
        int len=beginWord.length();

        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        Map<String,List<String>> map=new HashMap<>();
        Set<String> nextLevelVisited=new HashSet<>();

        boolean possible=false;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                String cur=queue.poll();
                char[] chars=cur.toCharArray();
                for (int i=0;i<len;i++){
                    char old=chars[i];
                    for(char c='a';c<='z';c++){
                        if(c==old){
                            continue;
                        }
                        chars[i]=c;
                        String ns=new String(chars);
                        if(ns.equals(endWord)){
                            possible=true;
                        }
                        if(!visited.contains(ns)&&wordSet.contains(ns)){
                            if(!nextLevelVisited.contains(ns)){
                                queue.offer(ns);
                                nextLevelVisited.add(ns);
                            }

                            if(map.get(cur)==null){
                                map.put(cur,new ArrayList<>());
                            }
                            map.get(cur).add(ns);
                        }
                    }
                    chars[i]=old;
                }
            }
            if(possible){
                break;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }

        if(!possible){
            return lists;
        }

        Deque<String> path=new LinkedList<>();
        path.addLast(beginWord);
        dfs(beginWord,endWord,path,map,lists);

        return lists;
    }

    private void dfs(String beginWord, String endWord, Deque<String> path, Map<String, List<String>> map, List<List<String>> lists) {
        if(beginWord.equals(endWord)){
            lists.add(new ArrayList<>(path));
            return;
        }
        if(!map.containsKey(beginWord)){
            return;
        }
        List<String> list=map.get(beginWord);
        for(String word:list){
            path.addLast(word);
            dfs(word,endWord,path,map,lists);
            path.removeLast();
        }
    }

    private void addToMap(Map<String, List<String>> map, boolean swap, String cur, String ns) {
        if(swap){
            String temp=cur;
            cur=ns;
            ns=temp;
        }
        if(map.get(cur)==null){
            map.put(cur,new ArrayList<>());
        }
        map.get(cur).add(ns);
    }
}
