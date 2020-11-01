/**
 * 实现 Trie (前缀树)  https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    boolean isEnd;
    Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    public void insert(String word) {
        if(word==null||word.length()==0) return;
        Trie cur=this;
        for(int i=0;i<word.length();i++){
            if(cur.next[word.charAt(i)-'a']==null) cur.next[word.charAt(i)-'a']=new Trie();
            cur=cur.next[word.charAt(i)-'a'];
        }
        cur.isEnd=true;
    }

    public boolean search(String word) {
        Trie node=searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    Trie searchPrefix(String word){
        if(word==null||word.length()==0) return null;
        Trie cur=this;
        for(int i=0;i<word.length();i++){
            Trie node=cur.next[word.charAt(i)-'a'];
            if(node==null) return null;
            cur=node;
        }
        return cur;
    }
}
