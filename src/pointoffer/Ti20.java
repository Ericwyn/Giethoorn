package pointoffer;

import org.junit.Test;

import java.util.Stack;

/**
 *
 * 定义栈的数据结构
 * 请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 第一个思路就是设置一个临时的栈
 * 将原本的栈里的东西全部倒出来然后在全部倒进去，这样来便利一遍对象
 * 虽然也 AC 了，但还是这样效率有点低
 *
 * 运行时间：15ms
 * 占用内存：9268k
 *
 * Created by Ericwyn on 18-5-19.
 */
public class Ti20 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> temp;
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (temp==null){
            temp = new Stack<>();
        }
        int min = stack.peek();
        int tempNum = 0;
        while (!stack.empty()){
            tempNum = stack.pop();
            if (tempNum < min){
                min = tempNum;
            }
            temp.push(tempNum);
        }
        while (!temp.empty()){
            stack.push(temp.pop());
        }
        return min;
    }


    @Test
    public void test(){
        Ti20 ti20 = new Ti20();
        ti20.push(15);
        ti20.push(12);
        ti20.push(2);
        ti20.push(7);
        ti20.push(65);
        ti20.push(3);
        System.out.println(ti20.min());
    }

}

