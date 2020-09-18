import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode做题-N叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrderQueue(Node root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.remove();
                list.add(node.val);
                queue.addAll(node.children);
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> _levelorderRecursion(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        _levelorder(root,list,0);//这个很巧妙
        return list;
    }

    private void _levelorder(Node root, List<List<Integer>> list,int level) {
        if(root==null){
            return;
        }
        if(list.size()<=level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        for(Node node:root.children){
            _levelorder(node,list,level+1);
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
