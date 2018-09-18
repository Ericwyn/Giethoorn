package pointoffer;

import org.junit.Test;

/**
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 *
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * Created by Ericwyn on 18-9-2.
 */
public class Ti31 {
    /**
     * 第一个思路，将其变成字符串然后统计
     *
     * 运行时间：67ms
     * 占用内存：13716k
     *
     * 运行时间有点多啊....
     *
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        String str ;
        for (int i=1;i<=n;i++){
            str = ""+i;
            for (int j=0;j<str.length();j++){
                if (str.charAt(j) == '1'){
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
}
