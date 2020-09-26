import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Leetcode做题-翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class 翻转二叉树 {
    public TreeNode invertTree_BFS(TreeNode root) {//BFS
        if(root==null){
            return root;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public TreeNode invertTree_DFS(TreeNode root) {//DFS
        if(root==null){
            return root;
        }

        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
