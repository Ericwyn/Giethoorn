package pointoffer;

/**
 *
 * 变态版跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  n:
 *  1:
 *      1
 *  2:
 *      1+1
 *      2
 *  3:
 *      1   +2
 *      1+1 +1
 *      2   +1
 *      3   +0
 *  4:
 *      1       +3
 *      1+1     +2
 *      2       +2
 *      1+2     +1
 *      1+1+1   +1
 *      2+1     +1
 *      3+0     +1
 *      4       +0
 *
 *  规律是 2 的 (n-1) 次方 平方
 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ti9 {

    // 运行时间：11ms
    // 占用内存：9256k
    public int JumpFloorII(int target) {
        if (target<1){
            return 0;
        }else {
            return (int)Math.pow(2,target-1);
        }
    }
}
