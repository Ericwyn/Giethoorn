package pointoffer;

import java.util.HashSet;

/**
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * Created by Ericwyn on 18-9-17.
 */
public class Ti36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 直接用 set 存储，非常暴力
     *
     * 运行时间：30ms
     * 占用内存：9712k
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode temp = pHead1;
        while (temp != null){
            nodeSet.add(temp);
            temp = temp.next;
        }

        temp = pHead2;
        while (temp != null){
            if (nodeSet.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 一般的正确解法
     * 因为两条链表有交叉，所以其实是一个 Y 形状，而不是一个 X 形状
     *
     * 也就是从某一点开始到最后一点，两条链表都是一样的
     *
     * 我们用一个栈在存储，然后从后面往前遍历就好了
     *
     * 又或者是反转两次链表然后从后面往前面遍历
     *
     *
     * 运行时间：30ms
     * 占用内存：9712k
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode temp = pHead1;
        while (temp != null){
            nodeSet.add(temp);
            temp = temp.next;
        }

        temp = pHead2;
        while (temp != null){
            if (nodeSet.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}
