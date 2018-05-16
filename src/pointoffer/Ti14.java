package pointoffer;

import org.junit.Test;

import java.util.List;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * Created by Ericwyn on 18-5-16.
 */
public class Ti14 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    // 双指针算法
    // 第一个指针先往前移动 k-1 个位置
    // 然后第二个指针开始从 head 开始，随着第一个指针也一个个向前移动，
    // 等到第一个指针到达最末尾的时候，第二个指针所指的对象就是倒数第 k 个了
    // 好棒！
    // 不过要判断的有
    // listNode 是否为 null
    // k 是否为 0
    // k 是否超过了 head 和 length

    // 运行时间：24ms

    // 占用内存：9428k
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        if (k==0){
            return null;
        }
        ListNode qian = head;
        ListNode hou = head;
        for (int i=0;i<k-1;i++){
            if (qian.next!=null){
                qian = qian.next;
            }else {
                // 代表 k 超过了链表长度
                return null;
            }
        }
        while (qian.next!=null){
            qian = qian.next;
            hou = hou.next;
        }
        return hou;
    }

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        ListNode head = first;
        for (int i=2;i<10;i++){
            first.next = new ListNode(i);
            first = first.next;
        }
        System.out.println(FindKthToTail(head,2).val);
    }
}
