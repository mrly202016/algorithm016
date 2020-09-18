import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode做题-N叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        _postorder(root,list);
        return list;
    }

    private void _postorder(Node root, List<Integer> list) {
        if(root==null){
            return;
        }

        for(Node node:root.children){
            _postorder(node,list);
        }
        list.add(root.val);
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
