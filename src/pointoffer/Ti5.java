package pointoffer;

import java.util.Stack;

/**
 *
 * 用2个栈来维护一个队列
 * 完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 基本思想是把一个 stack 当成缓存
 * 想象一下，我们把 3 个球装到杯子里面（杯子就是一个后进先出的 stack ）
 * 然后我们想把最下面的那个球拿出来， 所以我们要先把球一个个放进第二个杯子里面 （ 第二个 stack ）
 * 然后拿出最底下的那个 （pop）
 * 然后再把第二个杯子 （被当成缓存的的 stack ）里面的球再一个个返回第一个杯子里面
 *
 * 方法 1 的话是每一次出队，都将 stack1 倒到 stack2 然后在把 stack2 倒回 stack1
 * 然而这种是没有必要的，你可以让 stack2 先满着而 stack1 空着
 *
 * 这个时候，如果下一次是一次 pop 的话，直接将 stack2 顶部拿出就好了
 * 只有当又变回 push 的时候，才又将 stack2 倒回来
 *
 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ti5 {
    Stack<Integer> stack1 = new Stack<Integer>();       // 第一个杯子
    Stack<Integer> stack2 = new Stack<Integer>();       // 第二个杯子 缓存

    //方法1
//    public void push(int node) {
//        stack1.push(node);
//    }

    //优化
    public void push(int node){
        if (stack2.empty()){
            stack1.push(node);
        } else {
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
    }

    //方法1
//    public int pop() {
//        int temp = 0;
//        while (!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        temp = stack2.pop();
//        while (!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
//        return temp;
//    }

    //优化
    public int pop(){
        if (stack1.empty()){
            return stack2.pop();
        } else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
