# 学习总结

## BFS题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/) | BFS很好解，尝试DFS |
| [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/) | 这个题目想了很久才理解，其关键就是画出决策树图，然后转换成BFS，不要用人脑去理解这个题，要用机器思维 |
| [单词接龙](https://leetcode-cn.com/problems/word-ladder/) | 这个题双向BFS比较快，但要注意细节优化，用Set存单词字典比较好 |
| [单词接龙II](https://leetcode-cn.com/problems/word-ladder-ii/) | [先看懂这个大哥的题解](https://leetcode-cn.com/problems/word-ladder-ii/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you--2/)，这个题目是迄今为止连题目都比较难读懂的，因为有很多细节要去理解，返回链路上所以节点，增加了题目的难度。首先要想到最短路径用BFS，然后路径搜索想到用DFS，路径在BFS中保存，保存方式就是父节点和子节点集合，用Map<String,List<String>>，最后用beginword和这个Map进行DFS |


## DFS题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 二刷的时候就发现BFS有些细节都忘了，要多刷多理解，就是一个**Flood Fill**类型题 |
| [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/) | 这个题跟岛屿数量类似，都是**Flood Fill**类型的题，以当前格子为起点，向周围一圈8个格子扩散，也可以用BFS做，用BFS的时候有个小技巧，不一定需要visited数组，跟岛屿数量类似 |

## 动态规划题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [零钱兑换](https://leetcode-cn.com/problems/coin-change/) | 从最基本的回溯到自顶向下的动态规划，再到自下而上的动态规划（推荐），再到回溯+剪枝 |

## 二分查找题
| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | 这个题主要是区分mid在左半有序区还是右半有序区，再然后判断target的范围 |
| [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | 根据mid，从2端缩进 |