package pointoffer;

import org.junit.Test;

/**
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * Created by Ericwyn on 18-5-16.
 */
public class Ti13 {

    // 运行时间：23ms
    // 占用内存：9296k
    // 直接用2个新数组来存储
    public void reOrderArray(int [] array) {
        int[] n1 = new int[array.length];
        int[] n2 = new int[array.length];
        int count1 = 0;
        int count2 = 0;
        for (int anArray : array) {
            if (anArray % 2 == 1) {
                n1[count1++] = anArray;
            } else {
                n2[count2++] = anArray;
            }
        }
        for (int i=0;i<count1;i++){
            array[i] = n1[i];
        }
        for (int i=count1;i<array.length;i++){
            array[i] = n2[i-count1];
        }
    }

    //运行时间：23ms
    //占用内存：9352k
    // 改进一
    // 只用一个新数组来存储，只是奇数从前排到后，偶数从后排到前，然后再替换
    public void reOrderArray2(int [] array) {
        int[] n1 = new int[array.length];
        int count1 = 0;
        int count2 = array.length-1;
        for (int anArray : array) {
            if (anArray % 2 == 1) {
                n1[count1++] = anArray;
            } else {
                n1[count2--] = anArray;
            }
        }
        for (int i=0;i<count1;i++){
            array[i] = n1[i];
        }
        for (int i=array.length-1;i>count2;i--){
            array[count1++] = n1[i];
        }
    }

    @Test
    public void test(){
        int[] a= new int[]{1,2,3,4,5,6,7,8,9};
        reOrderArray2(a);
        System.out.println(a.length);
    }

}
