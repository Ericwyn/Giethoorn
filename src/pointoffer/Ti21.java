package pointoffer;

import org.junit.Test;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 第一思路就是，搞个辅助栈，然后一个记录进一个记录出，最后看看能否和输入的序列对上，对不上的话证明是错的
 *
 * 具体实现的时候，
 * 就是不断的吧 压入顺序中的第一个数 push 到里面去
 * 然后开始循环判断
 *
 *      如果栈的顶部元素，与 pop队列中的当前元素相同的话，就 pop 出来
 *      否则的话，就压入下一个
 *
 *      例如
 *      popA 的当前元素为 4
 *      压入 1,2,3,4 进去之后
 *      peek 为 4，与 popA 的当前元素相等
 *      所以 辅助栈 pop() ，变成了 1,2,3 然后 popA 的元素指针指向 5
 *      下一次判断，判断 peek = 3 != 5，所以压入 pushA 当中的下一个元素，
 *      辅助栈变成 1,2,3,5
 *
 *      peek 为 5，与 popA 的当前元素 5 相同
 *      所以 辅助栈 pop() ，变成了 1,2,3 然后 popA 的元素指针指向 3
 *      下一次判断，判断 peek = 3 != 3
 *      所以 辅助栈 pop() ，变成了 1,2 然后 popA 的元素指针指向 2
 *      下一次判断，判断 peek = 2 != 2
 *      所以 辅助栈 pop() ，变成了 1 然后 popA 的元素指针指向 1
 *      下一次判断，判断 peek = 1 != 1
 *      所以 辅助栈 pop() ，变成了 1 然后 popA 的元素指针指向 1
 *      这个时候 popA 的元素指针指向了 popA.length 了，越界，程序退出
 *
 *      判断 辅助栈是否为空，是的话证明队列正确
 *
 *
 * Created by Ericwyn on 18-5-20.
 */
public class Ti21 {

    //运行时间：15ms
    //占用内存：9412k
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> inStack = new Stack<>();
        int aCount = 0;
        int bCount = 0;
        inStack.push(pushA[aCount++]);
        while (aCount<=pushA.length && bCount<popA.length){
            if (inStack.peek() == popA[bCount]){
                inStack.pop();
                bCount++;
            }else {
                if (aCount<pushA.length){
                    inStack.push(pushA[aCount++]);
                }else {
                    break;
                }
            }
        }
        return inStack.empty();
    }

    @Test
    public void test(){
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,2,3,1}));
    }
}
