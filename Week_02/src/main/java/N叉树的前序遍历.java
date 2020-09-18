import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode做题-N叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        _preorder(root,list);
        return list;
    }

    private void _preorder(Node root, List<Integer> list) {
        if(root==null){
            return;
        }

        list.add(root.val);
        for(Node node:root.children){
            _preorder(node,list);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
