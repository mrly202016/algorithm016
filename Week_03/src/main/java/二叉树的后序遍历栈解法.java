import java.util.*;

/**
 * Leetcode做题-二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class 二叉树的后序遍历栈解法 {
    public List<Integer> postorderTraversalStack(TreeNode root) {//推荐这个，国外大神的解法
        LinkedList<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //这个是点睛之笔，后add进来的出现在前面，这样就要先把根入栈，再把右入栈，最后是左入栈，最终得到的结果就是左右根
            list.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        _recursion(root,list);
        return list;
    }

    private void _recursion(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        _recursion(root.left,list);
        _recursion(root.right,list);
        list.add(root.val);
    }

    class TreeNode { int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
