/**
 * leetcode做题-两数之和  https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class 反转链表 {
    ListNode prev=null;

    public ListNode reverseListRecursion(ListNode head) {//递归
        ListNode cur=head;
        if(cur==null){
            return cur;
        }
        ListNode temp=cur.next;
        cur.next=prev;
        prev=cur;
        cur=temp;
        reverseListRecursion(cur);
        return prev;
    }

    public ListNode reverseList(ListNode head) {//迭代
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


