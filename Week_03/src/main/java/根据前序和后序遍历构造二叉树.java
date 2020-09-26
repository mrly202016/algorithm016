import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class 根据前序和后序遍历构造二叉树 {
    int[] pre=null;
    int[] post=null;
    Map<Integer,Integer> postMap=new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre=pre;
        this.post=post;
        for(int i=0;i<post.length;i++){
            postMap.put(post[i],i);
        }

        return _recursion(0,pre.length-1,0,post.length-1);
    }

    //https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/kan-wo-jiu-gou-liao-san-chong-bian-li-fang-shi-g-2/
    private TreeNode _recursion(int preStart, int preEnd,int postStart,int postEnd) {
        if(preStart>preEnd||postStart>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(pre[preStart]);
        if(preStart==preEnd){
            return root;
        }
        int post_index=postMap.get(pre[preStart+1]);

        root.left=_recursion(preStart+1,preStart+1+post_index-postStart,postStart,post_index);
        root.right=_recursion(preStart+1+post_index-postStart+1,preEnd,post_index+1,postEnd-1);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
