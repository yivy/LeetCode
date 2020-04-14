/**
 * @description:
 * @author: mengwenyi
 * @Date: 2020/3/8 12:16
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    /**
     * @description: 输出
     * @author: mengwenyi
     * @date: 2020/3/10 17:31
     */
    public static void print(ListNode listNode){
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
