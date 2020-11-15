import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词  https://leetcode-cn.com/problems/valid-anagram/
 */
public class 有效的字母异位词二刷 {
    public static void main(String[] args) {
        有效的字母异位词二刷 t=new 有效的字母异位词二刷();
        System.out.println(t.isAnagram("anagram","nagaram"));
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(map.getOrDefault(s.charAt(i),0)<0) count++;
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(i>=t.length()) return false;
            if(map.getOrDefault(t.charAt(i),0)>0) count++;
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        return count==s.length()&&count==t.length();
    }

    public boolean isAnagram1(String s, String t) {
        char[] char_s=s.toCharArray();
        char[] char_t=t.toCharArray();
        mergeSort(char_s,0,char_s.length-1);
        mergeSort(char_t,0,char_t.length-1);
        return new String(char_s).equals(new String(char_t));
    }

    void mergeSort(char[] chars,int left,int right){
        if(left>=right) return;
        int mid=(left+right)>>>1;
        mergeSort(chars,left,mid);
        mergeSort(chars,mid+1,right);
        merge(chars,left,mid,right);
    }

    private void merge(char[] chars, int left, int mid, int right) {
        char[] temp=new char[right-left+1];
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right) temp[k++]=chars[i]<chars[j]?chars[i++]:chars[j++];
        while(i<=mid) temp[k++]=chars[i++];
        while(j<=right) temp[k++]=chars[j++];
        for(int p=0;p<temp.length;p++) chars[left+p]=temp[p];
    }

    public boolean isAnagram(String s, String t) {
        int[] chars=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)-'a']++<0) count++;
            if(i>=t.length()) return false;
            if(chars[t.charAt(i)-'a']-->0) count++;
        }
        return count==s.length()&&count==t.length();
    }
}
