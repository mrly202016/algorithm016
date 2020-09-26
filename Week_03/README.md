# 学习总结

## 二叉树题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | 重新用栈来做，发现国外大神很多优秀解法 |
| [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) | 重新用栈来做，发现国外大神很多优秀解法 |
| [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/) | 重新用栈来做，发现国外大神很多优秀解法 |
| [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/) | 递归很简单，体会DFS和BFS |
| [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/) | 递归值得思考，要考虑上下限的传递，然后也可以用DFS和BFS来实现 |
| [合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/) | 递归很简单，体会DFS和BFS |
| [从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Leetcode官网解法比较好理解 |
| [从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Leetcode官网解法比较好理解 |
| [根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/) | [这个大哥的解法比较通用](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/kan-wo-jiu-gou-liao-san-chong-bian-li-fang-shi-g-2/) |
| [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/) | [这个大哥的解法很巧妙，因为p或q一定都在树里，若pq有一个是祖先节点，那即使只遍历到祖先节点返回，另一个遍历不到，那也就证明返回到这个是祖先节点](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/) |

## 递归题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | 抽象思维，找重复子问题，处理的时候加限制条件 |