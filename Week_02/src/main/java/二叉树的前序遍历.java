import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode做题-二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        _preorder(root,list);
        return list;
    }

    private void _preorder(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        list.add(root.val);
        _preorder(root.left,list);
        _preorder(root.right,list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
