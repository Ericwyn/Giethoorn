package pointoffer;

import org.junit.Test;

import java.math.BigInteger;

/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by Ericwyn on 18-5-15.
 */
public class Ti12 {
    // 直接暴力的话是 O(n)
    // 如果我们把他当成是开根号之后的平方来看的话，就能够变成 O(log n)
    public double Power(double base, int exponent) {
//        if (exponent%2 == 0){
//            double temp = 1;
//            for (int i=0;i<exponent)
//        }
        return 0;
    }

    // 能够 AC ，但是没什么用
    // 运行时间：48ms
    // 占用内存：10500k
//    public double Power(double base, int exponent) {
//        return Math.pow(base,exponent);
//    }


    @Test
    public void test(){
        System.out.println(Power(1.0,2));
    }
}
