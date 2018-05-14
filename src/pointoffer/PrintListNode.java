package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 * Created by Ericwyn on 18-5-14.
 */
public class PrintListNode {

    /**
     * 要考虑当 listNode 为null 时候的情况
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res;
        if (listNode.next == null){
            res = new ArrayList<>();
            res.add(listNode.val);
            return res;
        }else {
            res = printListFromTailToHead(listNode.next);
            res.add(listNode.val);
            return res;
        }
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> a = new ArrayList<>();
        while (listNode != null){
            a.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=a.size()-1;i>=0;i--){
            res.add(a.get(i));
        }
        return res;
    }

    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test(){
        ListNode node = new ListNode(1);
        ListNode first = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        ArrayList<Integer> list = printListFromTailToHead2(first);
        for (int i : list){
            System.out.print(i+",");
        }
    }
}
