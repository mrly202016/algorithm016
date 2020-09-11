/**
 * leetcode做题-合并两个有序链表  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//迭代
        ListNode pre=new ListNode(0);
        ListNode present=pre;

        while (l1!=null||l2!=null){
            if(l1==null){
                pre.next=l2;
                break;
            }
            if(l2==null){
                pre.next=l1;
                break;
            }

            if(l1.val<l2.val){
                pre.next=l1;
                pre=l1;
                l1=l1.next;
            }else {
                pre.next=l2;
                pre=l2;
                l2=l2.next;
            }
        }

        return present.next;
    }

    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {//递归
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next=mergeTwoListsRecursion(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoListsRecursion(l2.next,l1);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
