package pointoffer;

import org.junit.Test;

/**
 *
 * 思路很简单，实现起来逻辑有点复杂，就是设置两个指针，放在 list1 和 list2 的当前临时头结点
 * 比较两个临时头结点，取小的存放到返回 list 的当前头结点里面
 * 然后较小的那个头结点往后移动
 *
 * 等到其中有一个 list 的头结点为 null
 * 就把另一个 list 的头结点拼接到 返回 list 里面去就是了
 *
 * Created by Ericwyn on 18-5-18.
 */
public class Ti16 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 运行时间：24ms
    // 占用内存：9708k
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head1 = list1; // 指向了 list1 的当前节点
        ListNode head2 = list2; // 指向了 list2 的当前节点
        ListNode currentHead = null;    // 返回 List 的当前节点
        ListNode resHead = null;        // 返回 list 的头结点
        while (head1 != null && head2 != null){
            if ( head1.val < head2.val ){
                if (resHead == null){
                    resHead = new ListNode(head1.val);
                    currentHead = resHead;
                }else {
                    currentHead.next = new ListNode(head1.val);
                    currentHead = currentHead.next;
                }
                head1 = head1.next;
            }else {
                if (resHead == null){
                    resHead = new ListNode(head2.val);
                    currentHead = resHead;
                }else {
                    currentHead.next = new ListNode(head2.val);
                    currentHead = currentHead.next;
                }
                head2 = head2.next;
            }
        }
        //如果判断到为一个为 null 的话
        if (head1 == null){
            currentHead.next = head2;
        }else {
            currentHead.next = head1;
        }
        return resHead;
    }

    // 递归的算法，能够 AC 但是....本地测试好贤惠翻车
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge2(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }

    @Test
    public void test(){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);

        ListNode res = Merge(listNode1,listNode2);
        System.out.println(res.val);
    }
}
