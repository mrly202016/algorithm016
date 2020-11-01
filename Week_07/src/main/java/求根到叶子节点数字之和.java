/**
 * 求根到叶子节点数字之和  https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class 求根到叶子节点数字之和 {
    public static void main(String[] args) {
        求根到叶子节点数字之和 t=new 求根到叶子节点数字之和();
        TreeNode root=t.new TreeNode(1);
        TreeNode left=t.new TreeNode(2);
        TreeNode right=t.new TreeNode(3);
        root.left=left;
        root.right=right;
        System.out.println(t.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return _recursion(root,0);
    }

    private int _recursion2(TreeNode root, int sum) {
        if(root==null) return 0;
        int num=sum*10+root.val;
        if(root.left==null&&root.right==null) return num;
        return _recursion2(root.left,num)+_recursion2(root.right,num);
    }

    private int _recursion(TreeNode root, int sum) {
        int num=sum*10+root.val;
        if(root.left==null&&root.right==null) return num;
        int l=0,r=0;
        if(root.left!=null) l=_recursion(root.left,num);
        if(root.right!=null) r=_recursion(root.right,num);
        return l+r;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
