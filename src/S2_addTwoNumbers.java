/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/8 12:12
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class S2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==null && l2 ==null){
            return null;
        }
        int add=0;
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        while(l1!=null || l2!=null || add!=0){
            int nodeValue1 = l1 == null ? 0: l1.val;
            int nodeValue2 = l2 == null ? 0: l2.val;
            head.next = new ListNode((nodeValue1+nodeValue2+add)%10);
            head = head.next;
            add = (nodeValue1+nodeValue2+add)/10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2);
//        listNode1.next=new ListNode(4);
//        listNode1.next.next=new ListNode(3);
//
//        ListNode listNode2 = new ListNode(5);
//        listNode2.next=new ListNode(6);
//        listNode2.next.next=new ListNode(4);

        ListNode listNode1 = new ListNode(1);
        listNode1.next=new ListNode(8);

        ListNode listNode2 = new ListNode(0);

        S2_addTwoNumbers solution2 = new S2_addTwoNumbers();
        ListNode.print(solution2.addTwoNumbers(listNode1,listNode2));
    }
}
