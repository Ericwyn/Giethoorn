package pointoffer;

import org.junit.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *      先导知识
 *
 *      原码
 *      原码就是符号位加上真值的绝对值, 即用第一位表示符号, 其余位表示值. 比如如果是8位二进制:
 *           [+1]原 = 0000 0001
 *           [-1]原 = 1000 0001
 *           因为第一位是符号位，所以取值就是 [1111 1111,0111 1111]，也就是 [-127,127]
 *
 *      反码
 *      负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.而正数的反码没有变化
 *           [+1] = [0000 0001]原 = [0000 0001]反
 *           [-1] = [1000 0001]原 = [1111 1110]反
 *
 *      补码
 *      负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1).而正数的补码没有变化
 *           [+1] = [00000001]原 = [00000001]反 = [00000001]补
 *           [-1] = [10000001]原 = [11111110]反 = [11111111]补
 *
 *
 * 十进制转换成二进制就是....不断的除以 2 ，然后余数的 0 、 1 组合起来就是了
 *
 * Created by Ericwyn on 18-5-15.
 */
public class Ti11 {
    public int NumberOf1(int n) {
        boolean flag = false;
        if (n<-127){
            return 1;
        }
        if (n < 0 ){
            flag = true;
            n = -n;
        }
        String temp = "";
        while (n!=0){
            temp+=""+(n % 2);
            n = n/2;
        }
        String binary = "";
        for (int i=temp.length()-1;i>=0;i--){
            binary+=temp.charAt(i);
        }
        int count = 0;
        if (flag){
            //数一下0的数量
            for (int i=0;i<binary.length();i++){
                if (binary.charAt(i) == '0'){
                    count++;
                }
            }
            return 1+count;
        }else {
            for (int i=0;i<binary.length();i++){
                if (binary.charAt(i) == '1'){
                    count++;
                }
            }
            return count;
        }
    }

    @Test
    public void test(){
        System.out.println(NumberOf1(-1));
    }

}
