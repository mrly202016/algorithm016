import java.util.ArrayList;
import java.util.List;

/**
 * -二叉树的中序遍历  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        _inorder(root,list);
        return list;
    }

    private void _inorder(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        _inorder(root.left,list);
        list.add(root.val);
        _inorder(root.right,list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
