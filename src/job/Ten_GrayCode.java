package job;

import org.junit.Test;

/**
 *

 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。

 给定一个整数n，请返回n位的格雷码，顺序为从0开始。

 测试样例：
 1

 返回：["0","1"]

 第一次生成 0,1，第二次在后面各加0和1，一个变成2个，所以
 第二次生成 00,01, 10,11 ，第三次在第二次的基础上，分别在后面加 0和1 ，一个变 2 个，所以
 第三次生成 000,001, 010,011, 100,101, 110,111
 ......

 * Created by Ericwyn on 18-5-14.
 */
public class Ten_GrayCode {

    /**
     * 50 的时候会溢出,25时候不会
     * 毕竟不是尾递归
     *
     * 对内存考量很大
     * @param n
     * @return
     */
    public String[] getGray(int n) {
        if (n==1){
            return new String[]{"0","1"};
        }else {
            String[] res = new String[(int)Math.pow(2,n)];
            String[] pre = getGray(n-1);
            int count=0;
            for (String s:pre){
                if ((count/2)%2==0){
                    res[count++] = s+"0";
                    res[count++] = s+"1";
                }else {
                    res[count++] = s+"1";
                    res[count++] = s+"0";
                }
            }
            return res;
        }
    }

    @Test
    public void test(){
        for (String str:getGray(3)){
            System.out.print(str+",");
        }
    }

}
