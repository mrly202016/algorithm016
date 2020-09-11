/**
 * leetcode做题-两两交换链表中的节点  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairsRecursion(ListNode head) {//递归
        if(head==null||head.next==null){
            return head;
        }
        ListNode _2d = head.next;
        head.next = swapPairsRecursion(head.next.next);
        _2d.next = head;
        return _2d;
    }

    public ListNode swapPairs1(ListNode head) {//迭代1，迭代里推荐这个，是2的优化版
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode first=prev;
        while (prev.next!=null&&prev.next.next!=null){
            ListNode start=prev.next;//1
            ListNode end=prev.next.next;//2
            //按顺序往后交换，比较好理解
            prev.next=end;
            start.next=end.next;
            end.next=start;
            prev=start;
        }
        return first.next;
    }

    public ListNode swapPairs2(ListNode head) {//迭代2
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode cur=head;
        head=head.next;
        while (cur!=null&&cur.next!=null){
            ListNode temp1=cur.next.next;

            ListNode temp2=cur.next;
            prev.next=temp2;
            cur.next=temp1;
            temp2.next=cur;

            prev=cur;

            cur=temp1;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
