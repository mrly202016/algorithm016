import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化  https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        _recursion(root,sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        Deque<String> queue=new LinkedList<>(Arrays.asList(strs));
        return _recursionD(queue);
    }

    private TreeNode _recursionD(Deque<String> queue) {
        String val=queue.poll();
        if("null".equals(val)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left=_recursionD(queue);
        root.right=_recursionD(queue);
        return root;
    }

    private void _recursion(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        _recursion(root.left,sb);
        _recursion(root.right,sb);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
