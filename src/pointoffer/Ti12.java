package pointoffer;

import org.junit.Test;

import java.math.BigInteger;

/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 直接暴力的话，就是 O(n)
 *
 * 但是有快速幂算法，大意就是不断的计算通过算 2个的乘积得到 4 个的乘积得到 8 个的乘积这样一路下来
 *
 * 例如 A^8  = A * A * A * A * A * A * A * A
 *          = (A * A * A * A) * (A * A * A * A) = (A * A * A * A) ^ 2
 *          = a ^ 4 * a ^ 4
 *          = a ^ 2 * a ^ 2 * a ^ 2 * a ^ 2
 *          = a * a * .......
 *
 * 而当
 *
 * 而 n * n 的最优解法， 就是应该将 n 分解成
 *
 * 这样的话就只需要计算
 *
 * Created by Ericwyn on 18-5-15.
 */
public class Ti12 {

    // 简单快速幂
    // 运行时间：35ms
    // 占用内存：10504k
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1 ;
        }
        if (n == 1) {
            return base ;
        }
        if (exponent > 0){
            //利用递归方法，递归i-1次计算
            double temp = Power(base, n/2);
            // 位运算写法 double temp = Power(base, n>>1);
            temp = temp * temp ;
            // 位运算写法  if((n & 1) == 1)
            if(n % 2 == 1){
                temp = temp * base;
            }
            return temp;
        }else {
            // 负数的话就是 n 次方的倒数
            double temp = Power(base, n /= 2);
            temp = temp * temp ;
            if(n % 2 == 1){
                temp = temp * base;
            }
            return 1/temp;
        }
    }

    // 能够 AC ，但是没什么用
    // 运行时间：48ms
    // 占用内存：10500k
//    public double Power(double base, int exponent) {
//        return Math.pow(base,exponent);
//    }

    //暴力
    //运行时间：50ms
    //占用内存：10696k
    public double PowerA(double base,int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        if (base == 1.0){
            return 1;
        }
        // 正指数
        if (exponent > 0){
            double temp = 1.0;
            for (int i=1;i<=exponent;i++){
                temp = temp * base;
            }
            return temp;
        }else {
            double temp = 1.0;
            exponent = Math.abs(exponent);
            for (int i=1;i<=exponent;i++){
                temp = temp * base;
            }
            return 1/temp;
        }
    }

    @Test
    public void test(){
        System.out.println(Power(2,2));
    }
}
