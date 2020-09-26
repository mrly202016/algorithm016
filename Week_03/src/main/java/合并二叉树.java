import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 合并二叉树  https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class 合并二叉树 {
    public TreeNode mergeTrees_BFS(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        Queue<TreeNode[]> queue=new LinkedList<>();
        queue.offer(new TreeNode[]{t1,t2});
        while (!queue.isEmpty()){
            TreeNode[] nodes=queue.poll();
            if(nodes[1]==null){
                continue;
            }
            nodes[0].val=nodes[0].val+nodes[1].val;
            if(nodes[0].left==null){
                nodes[0].left=nodes[1].left;
            }else {
                queue.offer(new TreeNode[]{nodes[0].left,nodes[1].left});
            }
            if(nodes[0].right==null){
                nodes[0].right=nodes[1].right;
            }else {
                queue.offer(new TreeNode[]{nodes[0].right,nodes[1].right});
            }
        }
        return t1;
    }

    public TreeNode mergeTrees_DFS(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        Deque<TreeNode[]> stack=new LinkedList<>();
        stack.push(new TreeNode[]{t1,t2});
        while (!stack.isEmpty()){
            TreeNode[] nodes=stack.pop();
            if(nodes[1]==null){
                continue;
            }
            nodes[0].val+=nodes[1].val;
            if(nodes[0].left==null){
                nodes[0].left=nodes[1].left;
            }else {
                stack.push(new TreeNode[]{nodes[0].left,nodes[1].left});
            }
            if(nodes[0].right==null){
                nodes[0].right=nodes[1].right;
            }else {
                stack.push(new TreeNode[]{nodes[0].right,nodes[1].right});
            }
        }
        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        t1.val=t1.val+t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
