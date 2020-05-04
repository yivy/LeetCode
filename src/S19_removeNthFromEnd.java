/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/4/27 17:29
 */

import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class S19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = head;
        ListNode second = head;
        int t=0;
        while(first!=null){
            t++;
            first = first.next;
        }
        int i=1;
        while(second!=null){
            if(i==(t-n)){
                second.next=second.next.next;
                break;
            }else{
                second=second.next;
            }
            i++;
        }
        return dummyHead.next;
    }
    /**
     * @description: 双指针
     * @author: mengwenyi
     * @date: 2020/5/4 10:40
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        S19_removeNthFromEnd s19_removeNthFromEnd = new S19_removeNthFromEnd();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);

        ListNode.print(s19_removeNthFromEnd.removeNthFromEnd(listNode, 2));
//        String b="2";
//        String a=b;
//        b="3";
//        System.out.println(a);
    }
}
