package pointoffer;

import org.junit.Test;

/**
 *
 * 数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 *
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入
 * 1,2,3,4,5,6,7,0
 *
 * 输出
 * 7
 *
 * Created by Ericwyn on 18-9-5.
 */
public class Ti35 {
    public int InversePairs(int [] array) {
        int count = 0;
        for (int i=0;i<array.length-1;i++){
            for (int j=i;j<array.length;j++){
                if (array[i]>array[j]){
                    count++;
                }
            }
        }
        return count % 1000000007;
    }

    @Test
    public void test(){
        System.out.println(InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }

}
