package pointoffer;

import org.junit.Test;

import java.util.List;

/**
 *
 * 反转链表
 *
 * 1->2->3->4->5
 * 1<-2<-3 4->5
 * 就是想办法把中间的箭头的方向掉转
 * 时间复杂度为 O(n)
 *
 * Created by Ericwyn on 18-5-16.
 */
public class Ti15 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 运行时间：19ms
    // 占用内存：9552k
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        //只有一个节点
        if (head.next==null){
            return head;
        }
        //有 2 个结点
        if (head.next.next == null){
            head.next.next = head;
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
        // 有 3 个结点或以上
        ListNode pre;
        ListNode next;
        pre = head;
        next = pre.next;
        head = next.next;
        next.next = pre;
        pre.next = null;
        while (head.next!=null){
            pre = next;
            next = head;
            head = head.next;
            next.next = pre;
        }
        head.next = next;
        return head;
    }

    @Test
    public void test(){
        ListNode first = new ListNode(1);
        ListNode head = first;
        for (int i=2;i<=2;i++){
            first.next = new ListNode(i);
            first = first.next;
        }
        first = ReverseList(head);
        System.out.println(head.val);
    }


}
