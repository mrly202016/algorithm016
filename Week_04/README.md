# 学习总结

## BFS题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | BFS很好解，尝试DFS |
| [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | 这个题目想了很久才理解，其关键就是画出决策树图，然后转换成BFS，不要用人脑去理解这个题，要用机器思维 |
| [单词接龙](https://leetcode-cn.com/problems/word-ladder/) | 这个题双向BFS比较快，但要注意细节优化，用Set存单词字典比较好 |
| [单词接龙II](https://leetcode-cn.com/problems/word-ladder-ii/) | [先看懂这个大哥的题解](https://leetcode-cn.com/problems/word-ladder-ii/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you--2/)，这个题目是迄今为止连题目都比较难读懂的，因为有很多细节要去理解，返回链路上所以节点，增加了题目的难度。首先要想到最短路径用BFS，然后路径搜索想到用DFS，路径在BFS中保存，保存方式就是父节点和子节点集合，用Map<String,List<String>>，最后用beginword和这个Map进行DFS |
| [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 二刷的时候就发现BFS有些细节都忘了，要多刷多理解，就是一个Flood Fill类型题 |