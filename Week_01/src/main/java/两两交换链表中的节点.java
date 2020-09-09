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

    public ListNode swapPairs(ListNode head) {//迭代
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=head;
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
