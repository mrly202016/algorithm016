/**
 * Leetcode做题-环形链表II  https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while (true){
            if(f==null||f.next==null){
                return null;
            }
            s=s.next;
            f=f.next.next;
            if(s==f){
                break;
            }
        }

        //以下需要数学证明
        f=head;
        while (f!=s){
            s=s.next;
            f=f.next;
        }
        return f;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
