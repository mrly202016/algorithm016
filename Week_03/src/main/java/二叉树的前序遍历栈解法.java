import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的前序遍历栈法
 */
public class 二叉树的前序遍历栈解法 {
    public List<Integer> preorderTraversalStack(TreeNode root) {//推荐这个，国外大神的解法1，这个比较好理解
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalStack3(TreeNode root) {//国外大神的解法3，参照的是中序遍历
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> preorderTraversalStack2(TreeNode root) {//国外大神的解法2
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            if(root!=null){
                list.add(root.val);
                stack.push(root.right);
                root = root.left;
            }else {
                root=stack.pop();
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        _recursion(root,list);
        return list;
    }

    private void _recursion(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        _recursion(root.left,list);
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
