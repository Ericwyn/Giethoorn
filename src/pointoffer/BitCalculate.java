package pointoffer;

import org.junit.Test;

/**
 *
 * java 位运算
 *
 *      << 左移动，用 0 补位
 *      >> 右移动，正数用 0 补位，负数用 1 补位
 *
 *      >>> 无符号左移动，正负数都用 0 补位
 *
 *      & 与，全为 1 时候为 1，否则为 0
 *      | 或，全为 0 时候为 0，否则为 1
 *      ^ 亦或，当一个为 1 一个为 0 时候，才会 1，否则为 0 ， 101 ^ 011 = 110
 *      ~ 非，反过来，为 1 时候结果为 0 ，为 0 时候结果为 1
 *
 *      于此对应的 a >>= 1 ，代表 a = a >> 1，与 a += 1同理
 *
 * 基本规律
 *      -a = ~(a - 1) = ~a + 1
 *
 *      >>1 相当于 / 2
 *      <<1 相当于 × 2
 *
 *      奇数 & 1 = 1
 *      偶数 & 1 = 0
 *
 * Created by Ericwyn on 18-5-15.
 */
public class BitCalculate {

    //加法运算
    public static int add(int num1,int num2){
        int a = num1;
        int b = num2;
        int temp = (a&b);
        int c = temp<<1;
        while (c!=0){
            a = a^b;
            b = c;
            c = (a&b)<<1;
        }
        return a^b;
    }


    @Test
    public void test(){
        System.out.println(4&1);
    }

}
