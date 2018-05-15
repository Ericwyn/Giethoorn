package pointoffer;

import org.junit.Test;

/**
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 * 其实也是和斐波那契数列一样的动态规划
 *
 *      2*n 个，有两种方法可以达成
 *          1, 2*(n-1) 在加一个 打竖的 1×2
 *          2, 2*(n-2) 在加两个 打横的 1×2
 *
 *          所以就是 f(n) = f(n-1) + f(n-2)
 *
 *      而初始条件就是
 *          当 n = 1 时候，就是 2*1 的矩形，只能有一个打竖的来拼成，f(1) = 1
 *          当 n = 2 时候，就是 2*2 的矩形，只能有两个打竖或者两个打横的来拼成 f(2) = 2
 *
 *          n = 3 开始，f(3) 可以用 f(1) 加两个打横的来拼成，也可以用 f(2) 加一个打竖的来完成
 *              而 f(1) 和 f(2) 分别有 1 和 2 种方法实现
 *              所有 f(3) = f(1) + f(2) = 1 + 2 = 3
 *
 *          n = 4 ， f(4) = f(3) + f(2) = 3 + 2 = 5
 *          ......
 *
 *  然后这一题...好像我在 蓝桥杯 2018 年省赛上面见过....
 *  那时候不会做现在只觉得好简单....毕竟有前面几题的基础
 *
 * Created by Ericwyn on 18-5-15.
 */
public class Ti10 {
    public int RectCover(int target) {
        if (target < 1){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i=3;i<=target;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void test(){
        System.out.println(RectCover(3));
    }
}
