import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 二叉树的最大深度二刷
 */
public class 二叉树的最大深度二刷 {
    public int maxDepth_DFS(TreeNode root) {//迭代，DFS
        if(root==null){
            return 0;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<Integer> level=new ArrayDeque<>();
        stack.push(root);
        level.push(1);
        int max=0;
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            int deep=level.pop();
            max=Math.max(max,deep);

            if(node.left!=null){
                stack.push(node.left);
                level.push(deep+1);
            }
            if(node.right!=null){
                stack.push(node.right);
                level.push(deep+1);
            }
        }
        return max;
    }

    public int maxDepth_BFS(TreeNode root) {//迭代，BFS
        if(root==null){
            return 0;
        }
        int level=0;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            level++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
