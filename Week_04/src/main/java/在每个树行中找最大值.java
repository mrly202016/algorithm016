import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值  https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            while (size-->0){
                TreeNode node=queue.poll();
                max=Math.max(max,node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
