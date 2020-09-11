/**
 * Leetcode做题-K个一组翻转链表  https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode r=pre;

        ListNode end=pre;
        while (end.next!=null){
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null){
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next=null;
            pre.next=reverseList(start);
            start.next=next;
            pre=start;
            end=pre;
        }

        return r.next;
    }

    private ListNode reverseList(ListNode head) {
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

    public ListNode reverseKGroup_test(ListNode head, int k) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode temp=pre;

        int count=0;
        ListNode cur=head;
        while (cur!=null){
            ListNode t=cur.next;
            count++;
            if(count==k){
                ListNode start=pre.next;

                pre.next=cur;
                reverseList_test(pre.next,cur);
                pre=start;
                count=0;
            }
            cur=t;
        }

        return temp.next;
    }

    private void reverseList_test(ListNode start, ListNode end) {
        ListNode prev=end.next;
        while (start!=end.next){
            ListNode temp=start.next;
            start.next=prev;
            prev=start;
            start=temp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
