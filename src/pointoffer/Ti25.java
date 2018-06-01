package pointoffer;

import org.junit.Test;

/**
 *
 *
 *
 * Created by Ericwyn on 18-6-1.
 */
public class Ti25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //想着直接复制，发现行不通，只好看答案了
//    public RandomListNode Clone(RandomListNode pHead) {
//        if (pHead == null){
//            return null;
//        }
//        RandomListNode r2 = new RandomListNode(pHead.label);
//        if (pHead.random!=null){
//            r2.random = new RandomListNode()
//        }
//        RandomListNode pRes = r2.next;  // 指向返回的
//        RandomListNode p = pHead.next;  // 指向原来的
//        while (p != null){
//            pRes = new RandomListNode(p.label);
//            if (p.random!=null){
//                pRes.random = new RandomListNode(p.random.label);
//            }
//            pRes = pRes.next;
//            p = p.next;
//        }
//        return r2;
//    }

    /**
     * 我们在原链表的基础上，先插入新的节点
     * 每个节点后面都加入一个复制的节点，
     *
     *      原来： a -> b -> c -> d -> e
     *      复制:  a -> A -> b -> B -> c -> C -> d -> D -> e -> E
     *
     * 第一次复制完成之后就是上面的样子，然后我们还需要复制 random 的链接
     * 由于链表的结构还在，所以我们知道 a 的 random 指向了 d
     * 而 a 的下一个 A 其 random 指向的必然是 d 的下一个 D
     * 通过这种方法来完成 random 的设置
     *
     * 然后就是把一个链表拆分成 2 个就好了
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        do {
            RandomListNode temp = new RandomListNode(p.label);
            RandomListNode pNextTemp = p.next;
            p.next = temp;
            temp.next = pNextTemp;
            p = pNextTemp;
        }while (p!=null);
        p = pHead;
        while (p!=null){
            if (p.random!=null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        RandomListNode res = pHead.next;
        RandomListNode resHead = res;
        while (res.next!=null){
            res.next = res.next.next;
            res = res.next;
        }
        return resHead;
    }


    @Test
    public void test(){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        RandomListNode node6 = new RandomListNode(6);
        RandomListNode node7 = new RandomListNode(7);
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        node1.next.next.next.next = node5;
        node1.next.next.next.next.next = node6;
        node1.next.next.next.next.next.next = node7;
        node1.random = node7;
        node2.random = node6;
        node3.random = node5;

        RandomListNode r2 = Clone(node1);
        System.out.println(r2);
    }
}
