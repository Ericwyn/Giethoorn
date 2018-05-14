package pointoffer;

/**
 * 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 动态规划
 *
 *      假设跳到 x 的步骤算式是 f（x），然后所有的 f（x） 的数量是 n（f（x））
 *      例如
 *      跳到 1 那么
 *          f(1) = 1
 *          n (f(1)) = 1
 *      跳到 2 那么
 *          f(2) = 1+1
 *          f(2) = 2
 *          n (f(2)) = 1
 *      跳到 3 那么
 *          f(3) = 1+1 +1       f(2)+1
 *          f(3) = 2   +1       f(2)+1
 *          f(3) = 1   +2       f(1)+2
 *          n (f(3)) = 2        n(f(3)) = n(f(1)) + n(f(2))
 *      跳到 4 那么
 *          f(4) = 1+1+1 +1     f(3) +1
 *          f(4) = 1+2   +1     f(3) +1
 *          f(4) = 2     +2     f(2) +2
 *          f(4) = 1+1   +2     f(2) +2
 *          n(f(4)) = 3         n(f(4)) = n(f(2)) + n(f(3))
 *
 *      所以 n(f(x)) = n(f(x-1)) + n(f(x-1))
 *      是斐波那契数列！
 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ti8 {
    //运行时间：562ms
    //占用内存：9160k
    public int JumpFloor(int target) {
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        } else {
            return JumpFloor(target-1)+JumpFloor(target-2);
        }
    }

    //非递归
    // 19ms
    // 9032k
    public int JumpFloor2(int target) {
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        } else {
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
    }
}
