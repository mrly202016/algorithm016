import java.util.*;

/**
 * 二叉树的层序遍历  https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }
        dfs(root,0,lists);
        return lists;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> lists) {
        if(root==null){
            return;
        }
        if(lists.size()==level){
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        if(root.left!=null){
            dfs(root.left,level+1,lists);
        }
        if(root.right!=null){
            dfs(root.right,level+1,lists);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.removeFirst();
                if(node!=null){
                    list.add(node.val);
                    if(node.left!=null){
                        queue.addLast(node.left);
                    }
                    if(node.right!=null){
                        queue.addLast(node.right);
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
