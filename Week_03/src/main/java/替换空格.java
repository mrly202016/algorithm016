/**
 * Leetcode做题-替换空格  https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class 替换空格 {
    public String replaceSpace3(String s) {//这个就更精确一步
        int count=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                count++;
            }
        }

        char[] chars = new char[s.length()+2*count];
        int index=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                chars[index++]='%';
                chars[index++]='2';
                chars[index++]='0';
            }else {
                chars[index++]=c;
            }
        }
        return new String(chars,0,index);
    }

    public String replaceSpace2(String s) {//StringBuilder容有性能损耗，所以提前创建3倍空间'%'、'2'、'0'
        char[] chars = new char[3*s.length()];//假设全是空格，就需要扩3倍
        int index=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                chars[index++]='%';
                chars[index++]='2';
                chars[index++]='0';
            }else {
                chars[index++]=c;
            }
        }
        return new String(chars,0,index);
    }

    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
