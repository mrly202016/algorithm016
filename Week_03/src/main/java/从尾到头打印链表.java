import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从尾到头打印链表  https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class 从尾到头打印链表 {
    public int[] reversePrintStack(ListNode head) {
        Deque<ListNode> stack=new ArrayDeque<>();
        int count=0;
        while (head!=null){
            stack.push(head);
            head=head.next;
            count++;
        }
        int[] arr=new int[count];
        int index=0;
        while (!stack.isEmpty()){
            arr[index++]=stack.pop().val;
        }
        return arr;
    }

    public int[] reversePrint(ListNode head) {
        ListNode pre=null;
        int count=0;
        while (head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
            count++;
        }
        int[] arr=new int[count];
        int index=0;
        while (pre!=null){
            arr[index++]=pre.val;
            pre=pre.next;
        }
        return arr;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
