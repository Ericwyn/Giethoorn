package pointoffer;

import org.junit.Test;

/**
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
 *
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 题目说的 ： 非递减排序，是不是应该是 递减排序？
 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ti6 {

    //直接暴力，寻求最小值，能 AC
    // 350 ms
    public int minNumberInRotateArrayOld(int [] array) {
        if (array.length==0){
            return 0;
        }
        int min=array[0];
        for (int anArray : array) {
            if (anArray < min) {
                min = anArray;
            }
        }
        return min;
    }


    // 280 ms
    // 我觉得题目有问题
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }
        int temp = array[0];
        for (int i=0;i < array.length-1;i++){
            if (array[i] > array[i+1]){
                temp = array[i+1];
                break;
            }
        }
        return temp;
    }

    @Test
    public void test(){
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }
}
