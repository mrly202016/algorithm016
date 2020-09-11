/**
 * Leetcode做题-环形链表  https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode s=head;//慢指针每次走1步
        ListNode f=head.next;//快指针每次走2步
        while (s!=f){//因为快指针速度只比慢指针速度快1步，所以最终会相遇
            if(f==null||f.next==null){//不存在环的话快指针先结束
                return false;
            }
            s=s.next;
            f=f.next.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
