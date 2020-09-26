import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树  https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class 从中序与后序遍历序列构造二叉树 {
    int[] inorder=null;
    int[] postorder=null;
    int pe=0;
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {//这个容易理解
        this.inorder=inorder;
        this.postorder=postorder;
        this.pe=postorder.length-1;


        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return _recursion(0,inorder.length-1);
    }

    private TreeNode _recursion(int start, int end) {
        if(start>end){
            return null;
        }

        TreeNode root=new TreeNode(this.postorder[this.pe]);
        int ri=map.get(root.val);

        this.pe--;
        root.right=_recursion(ri+1,end);//注意顺序，先构造的是右子树
        root.left=_recursion(start,ri-1);
        return root;
    }

    //https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/kan-wo-jiu-gou-liao-san-chong-bian-li-fang-shi-g-2/
    public TreeNode buildTree2(int[] inorder, int[] postorder) {//解法1，这个比较通用
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return _recursion(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inMap);
    }

    TreeNode _recursion(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,Map<Integer,Integer> inMap){
        if(inStart>inEnd||postStart>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int root_index=inMap.get(root.val);
        root.left=_recursion(inorder,inStart,root_index-1,postorder,postStart,postStart+root_index-1-inStart,inMap);
        root.right=_recursion(inorder,root_index+1,inEnd,postorder,postStart+root_index-inStart,postEnd-1,inMap);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
