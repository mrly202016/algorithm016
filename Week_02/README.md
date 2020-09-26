# 学习总结

## 课后作业

1. 写一个关于 HashMap 的小总结

| API | 总结 |
| :- | :- |
| Put | <ul><li>根据key的hashCode()，通过hash函数计算在哈希表中要存放的索引位置</li><li>如果没有发生碰撞就直接存</li><li>如果发生碰撞，并且哈希表中元素不超过8个，就以链表形式在尾端插入，否则按红黑树存入</li><li>如果要插入的key已经存在，就替换旧值</li><li>如果空间不够就扩容</li></ul> |
| Get | <ul><li>根据key的hashCode()，通过hash函数计算在哈希表中的索引</li><li>根据key的equals()方法跟头节点比较，若相同直接返回节点值，否则遍历链表</li></ul> |


2. 树的面试题解法一般都是递归，为什么?

因为树的定义没有后继或便于循环的节点，只有左右节点，比较好的遍历方式就是对左右节点调用相同的递归函数。

## 哈希表题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/) | 跟猜数字类似，可以用map做，以变保存unicode字符，用map做的时候注意保存值的顺序 |
| [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | 根据char中元素出现的次数，生成新的字符串，存入map中 |
| [两个数组的交集II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/) |  |
| [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/) | 计算box的方式i/3*3+j/3，国际版的set存string组合 |
| [FizzBuzz](https://leetcode-cn.com/problems/fizz-buzz/) | 虽然是个简单题，但有很多地方可以思考 |

## 二叉树题

| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | 记忆二叉树3个顺序的遍历模板即可 |
| [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) | 记忆二叉树3个顺序的遍历模板即可 |
| [N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) | 跟二叉树遍历类似，只是有多个子节点而已 |
| [N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/) | 跟二叉树遍历类似，只是有多个子节点而已 |
| [最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/) | 用堆做 |
| [前K个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) | 很容易想到hashmap计数，然后用最小堆。桶排序的后面再看todo |
| [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/) | 简单的递归可做，但是扩展一下，可以尝试BFS和DFS |

## 数组题
| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/) | 参考leetcode评论区大神解法，任何一个丑数都是由前面的任一个丑数乘上(2,3,5)得到的，由此转化成3个有序数组的合并去重，有序数组合并就用多指针的方式，然后后移 |
| [删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/) | 通过左括号计数解决 |

## 图题
| 题目名 | 看Leetcode题解心得 |
| :- | :- |
| [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 深度优先遍历和广度优先遍历，广度优先遍历空间复杂度较小，可看成斜角线。并查集题解还未看 |