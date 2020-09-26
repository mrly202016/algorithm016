import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode做题-验证二叉搜索树  https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class 验证二叉搜索树 {
    public boolean isValidBSTInOrder_Stack(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Integer prev=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev!=null&&root.val<=prev){
                return false;
            }
            prev=root.val;
            root=root.right;
        }
        return true;
    }

    Integer pre=null;

    public boolean isValidBSTInOrder(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBSTInOrder(root.left)){
            return false;
        }
        if(pre!=null&&root.val<=pre){
            return false;
        }
        pre=root.val;
        return isValidBSTInOrder(root.right);
    }

    public boolean isValidBSTStack(TreeNode root) {//模拟递归栈
        Deque<TreeNode> stack=new LinkedList<>();
        Deque<Integer> lower=new LinkedList<>();
        Deque<Integer> upper=new LinkedList<>();
        stack.push(root);
        lower.push(null);
        upper.push(null);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            Integer min=lower.pop();
            Integer max=upper.pop();
            if(node==null){
                continue;
            }
            if(min!=null&&node.val<=min){
                return false;
            }
            if(max!=null&&node.val>=max){
                return false;
            }
            stack.push(node.left);
            lower.push(min);
            upper.push(node.val);
            stack.push(node.right);
            lower.push(node.val);
            upper.push(max);
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return _recursion(root,null,null);
    }

    private boolean _recursion(TreeNode root,Integer lower,Integer upper) {
        if(root==null){
            return true;
        }
        if (lower!=null&&root.val<=lower){
            return false;
        }
        if (upper!=null&&root.val>=upper){
            return false;
        }
        return _recursion(root.left,lower,root.val)&&_recursion(root.right,root.val,upper);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
