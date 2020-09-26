import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树  https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class 从前序与中序遍历序列构造二叉树 {
    int[] preorder=null;
    int[] inorder=null;
    int pres=0;
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {//这个比较好理解
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return _rescursion(0,inorder.length-1);
    }

    private TreeNode _rescursion(int left, int right) {
        if(left>right){
            return null;
        }

        TreeNode root=new TreeNode(preorder[pres]);
        int ri=map.get(root.val);
        pres++;

        root.left=_rescursion(left,ri-1);
        root.right=_rescursion(ri+1,right);
        return root;
    }

    //https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/kan-wo-jiu-gou-liao-san-chong-bian-li-fang-shi-g-2/
    public TreeNode buildTree2(int[] preorder, int[] inorder) {//这个解法比较通用
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return _recursion(inorder,0,inorder.length-1,preorder,0,preorder.length-1,inMap);
    }

    TreeNode _recursion(int[] inorder,int inStart,int inEnd,int[] preorder,int preStart,int preEnd,Map<Integer,Integer> inMap){
        if(inStart>inEnd||preStart>preEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int root_index=inMap.get(root.val);
        root.left=_recursion(inorder,inStart,root_index-1,preorder,preStart+1,preStart+1+root_index-1-inStart,inMap);
        root.right=_recursion(inorder,root_index+1,inEnd,preorder,preStart+1+root_index-1-inStart+1,preEnd,inMap);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
