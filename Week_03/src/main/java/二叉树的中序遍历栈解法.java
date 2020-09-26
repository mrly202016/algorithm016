import java.util.*;

/**
 * 二叉树的中序遍历栈解法
 */
public class 二叉树的中序遍历栈解法 {
    public List<Integer> inorderTraversalStack(TreeNode root) {//推荐这个，好理解，国外大神解法1
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversalStack2(TreeNode root) {//国外大神解法2
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                list.add(root.val);
                root=root.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        _recursion(root,list);
        return list;
    }

    private void _recursion(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        _recursion(root.left,list);
        list.add(root.val);
        _recursion(root.right,list);
    }

    public class TreeNode { int val;
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
