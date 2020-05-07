/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/5/7 11:24
 */

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class S21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        while(l1!=null || l2!=null){
            if(l1==null){
                node.next=new ListNode(l2.val);
                l2=l2.next;
                node=node.next;
                continue;
            }
            if(l2==null){
                node.next=new ListNode(l1.val);
                l1=l1.next;
                node=node.next;
                continue;
            }
            if(l1.val<l2.val){
                node.next=new ListNode(l1.val);
                l1=l1.next;
                node=node.next;
            }else{
                node.next=new ListNode(l2.val);
                l2=l2.next;
                node=node.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(4);

        ListNode listNode2=new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);
        S21_mergeTwoLists s21_mergeTwoLists = new S21_mergeTwoLists();
        ListNode.print(s21_mergeTwoLists.mergeTwoLists(listNode1,listNode2));
    }
}
