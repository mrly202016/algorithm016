import java.util.*;

/**
 * 单词搜索 II  https://leetcode-cn.com/problems/word-search-ii/
 */
public class 单词搜索II {
    public static void main(String[] args) {
        单词搜索II t=new 单词搜索II();
//        List<String> list=t.findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcd"});
        List<String> list=t.findWords(new char[][]{{'a','b'},{'a','a'}}, new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"});
        System.out.println(Arrays.toString(list.toArray()));
    }

    int[] ti=new int[]{-1,0,1,0};
    int[] tj=new int[]{0,1,0,-1};

    public List<String> findWords2(char[][] board, String[] words) {//推荐，优化版
        List<String> list=new ArrayList<>();
        TrieNode root=new TrieNode();
        for(String word:words) root.insert(word);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,list);
            }
        }
        return list;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> list) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#') return;

        char c=board[i][j];

        //这个地方就是不用在二维矩阵保存路径上字符的关键，不用从root开头判断，只把next往下传，一级一级判断
        root=root.next[c-'a'];
        if(root==null) return;

        if(root.word!=null){
            list.add(root.word);
            root.word=null;//这个地方置为空是为了防止出现重复的单词
        }

        board[i][j]='#';
        for(int k=0;k<ti.length;k++){
            dfs(board,i+ti[k],j+tj[k],root,list);
        }
        board[i][j]=c;
    }

    class TrieNode{//前缀树优化
        TrieNode[] next;
        String word;//这里直接保存word，这样在二维矩阵中就不用StringBuilder保存路径上的字符

        public TrieNode() {
            next=new TrieNode[26];
        }

        void insert(String word){
            if(word==null||word.length()==0) return;
            TrieNode root=this;
            char[] chars=word.toCharArray();
            int i=0;
            for(char c:chars){
                i=c-'a';
                if(root.next[i]==null) root.next[i]=new TrieNode();
                root=root.next[i];
            }
            root.word=word;
        }
    }



    public List<String> findWords(char[][] board, String[] words) {
        Trie root=new Trie();
        for(String word:words) root.insert(word);

        Set<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.startsWith(String.valueOf(board[i][j]))){
                    StringBuilder path=new StringBuilder();
                    dfs(board,i,j,path,root,set);
                }
            }
        }

        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, StringBuilder path, Trie root, Set<String> set) {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#') return;

        char c=board[i][j];
        path.append(c);
        if(!root.startsWith(path.toString())){
            path.deleteCharAt(path.length()-1);
            return;
        }

        if(root.search(path.toString())){
            set.add(path.toString());
        }

        board[i][j]='#';
        for(int k=0;k<ti.length;k++){
            dfs(board,i+ti[k],j+tj[k], path, root,set);
        }
        board[i][j]=c;
        path.deleteCharAt(path.length()-1);
    }

    class Trie{
        Trie[] next;
        boolean isEnd;

        public Trie() {
            next=new Trie[26];
            isEnd=false;
        }

        void insert(String word){
            if(word==null||word.length()==0) return;
            Trie root=this;
            int index=0;
            for(int i=0;i<word.length();i++){
                index=word.charAt(i)-'a';
                if(root.next[index]==null) root.next[index]=new Trie();
                root=root.next[index];
            }
            root.isEnd=true;
        }

        boolean search(String word){
            if(word==null||word.length()==0) return false;
            Trie node=searchPrefix(word);
            return node!=null&&node.isEnd;
        }

        boolean startsWith(String word){
            return searchPrefix(word)!=null;
        }

        private Trie searchPrefix(String word){
            if(word==null||word.length()==0) return null;
            Trie root=this;
            int index=0;
            for(int i=0;i<word.length();i++){
                index=word.charAt(i)-'a';
                if(root.next[index]==null) return null;
                root=root.next[index];
            }
            return root;
        }
    }
}
