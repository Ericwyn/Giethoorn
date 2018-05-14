package pointoffer;

import org.junit.Test;

/**
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *
 * n<=39
 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ti7 {

    // 直接递归 980多ms 差点超时
    // 递归的话，会重复计算很多
    // Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
    //              = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
    //              = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
    // 每次都有很多的重复计算
    public int FibonacciOld(int n) {
        if (n == 0){
            return 0;
        }
        if (n==1){
            return 1;
        }else if (n==2){
            return 1;
        }else {
            return FibonacciOld(n-1)+FibonacciOld(n-2);
        }
    }


    // 15ms !
    // 迭代！
    public int Fibonacci(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3;i <= n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void test(){
        System.out.println(Fibonacci(0));
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(8));
    }
}
