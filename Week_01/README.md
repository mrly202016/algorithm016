# 学习总结

## 课后作业

1. 用新API改写Deque代码

```java
class DequeNewApi {
    public static void main(String[] args){
        Deque<String> deque=new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str=deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
    
        while (!deque.isEmpty()){
            System.out.println(deque.removeFirst());
        }
    }
}
```

2. 分析Queue源代码

| API | 说明 |
| :- | :- |
| add | 在容量允许的情况下添加元素成功返回true，否则就会抛异常 |
| offer | 在容量允许的情况下添加元素成功返回true，否则返回false，不抛异常 |
| remove | 删除并返回队列头元素，队列为空时抛异常 |
| poll | 删除并返回队列头元素，队列为空时返回null |
| element | 返回队列头元素但不删除，队列为空时抛异常 |
| peek | 返回队列头元素但不删除，队列为空时返回null |

3. 分析PriorityQueue源代码

PriorityQueue是一个小顶堆，通过构造时传入比较器或按自然顺序排序来实现元素大小的比较。

| API | 说明 |
| :- | :- |
| add/offer | 插入非空元素，如有必要就扩容，自下而上与父节点比较大小，小于就交换，返回true或false |
| remove/poll | 将队列头元素弹出，将队尾元素移到队首，自上而下与子节点比较大小 |

## 跳跃表

跳跃表的出现是为了解决链表查询时间复杂度的问题，方法是通过增加多级索引。假设有n个节点，每2个节点增加一级索引，在一级索引之上，每2个节点再增加一个索引，依次类推，最高级索引处有2个节点，那每级索引的节点数就是：
> n/2 &nbsp;&nbsp; n/4 &nbsp;&nbsp; n/8 &nbsp;&nbsp; ... &nbsp;&nbsp; 4 &nbsp;&nbsp; 2  

第k层节点也就是n/2^k=2，k=log2n-1，也就是logn。每层索引最多查找3个节点，所以跳表的查询时间复杂度是o(3*logn)，也就是o(logn)。插入删除的复杂度是查找到之后o(1)，所以插入删除的时间复杂度也是o(logn)。


## 数组题

数组题里面有些用的比较多的方法是双指针，其余就是审题和数组遍历逻辑的顺序

#### 爬楼梯

因为上最后一级台阶要么走一步，要么走两步，所以类似Fibonacci，也就是公式：
> f(n)&nbsp;=&nbsp;f(n-1)&nbsp;+&nbsp;f(n-2)  

所以有2种解法：
* 递归求解
* 滚动数组

###### 递归求解的时间复杂度分析

根据那个公式可以很容易画出二叉树，这个公式得出的二叉树深度为**n-1**，所以时间复杂度最大为2^(n-1)-2，也即2^n

###### 滚动数组的时间复杂度分析

很容易看出时间复杂度是o(n)，而且空间复杂度是o(1)，巧妙的运用了临时变量。


#### 盛水最多的容器

双指针，2头缩进

#### 移动零

双指针

#### 两数之和

空间换时间，升维，转化解题思路，把找2转化为求某数是否存在

#### 加一

这个题没有什么好方法，就是审题吧，如果当成数字来做，极端情况会越界，还是看国际版的解法

#### 三数之和

这个是目前数组题里最难的，也是代码实现行数最多的。区别于两数之和，它需要遍历目标target，没有采用hash。重点是遍历逻辑和去重方法，指针移动的时机和和盛最多水的容器类似。也是相当于双指针


## 链表题

 
