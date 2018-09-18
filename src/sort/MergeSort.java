package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 归并排序
 *
 * Created by Ericwyn on 18-9-5.
 */
public class MergeSort {

    public void sort(int[] num){
        mergeSort(num, 0, num.length-1);
    }

    /**
     *
     * Test
     * 将有序的 a 和 b 合并到 c
     * c 也是有序的
     *
     * @param a
     * @param b
     * @param c
     */
    public void merge(int[] a, int[] b, int[] c){
        int i=0,j=0,k=0;
        while (i < a.length || j < b.length){
            if (i == a.length){
                c[k++] = b[j++];
            }else if (j == b.length){
                c[k++] = a[i++];
            }else {
                if (a[i] > b[j]){
                    c[k++] = b[j++];
                }else {
                    c[k++] = a[i++];
                }
            }
        }

    }

    /**
     *
     * 将 num[left] ~ num[right] 看成是两个数组
     * 数组 1
     *      left ~ center
     *
     * 数组2
     *      center + 1 ~ right
     *
     * @param num
     * @param left
     * @param center
     * @param right
     */
    public void merge(int[] num,int left, int center, int right){
        // 这里要 + 1
        int[] temp = new int[right-left+1];
        int i=left,j = center+1,k=0;
        // 这里是 <=
        while (i <= center || j <= right){
            if (i > center){
                temp[k++] = num[j++];
            }else if(j > right){
                temp[k++] = num[i++];
            }else {
                if (num[i] > num[j]){
                    temp[k++] = num[j++];
                }else {
                    temp[k++] = num[i++];
                }
            }
        }
        for (i=0,j=left;i<temp.length;i++,j++){
            num[j] = temp[i];
        }
    }


    /**
     * 归并排序核心
     *
     * 归 ： 将一个长的数组不断的递归成小的、已经有序的小数组
     * 并 ： 将已经有序的两个小数组，合并变成一个有序的大数组
     *
     * @param num
     * @param left
     * @param right
     */
    public void mergeSort(int[] num, int left, int right){
        if (left >= right){
            return;
        }
        System.out.println("start:"+left+",end:"+right+" "+Arrays.toString(num));
        // 找出中间元素作为分隔
        int center = (right + left) / 2;
        // 递归 左边排序
        mergeSort(num, left, center);
        // 递归 右边排序
        mergeSort(num, center + 1, right);
        // 合并
        merge(num,left,center,right);
    }


    @Test
    public void test(){
        int[] temp = new int[]{5,4,2,7,6,1,8,3,9,0};
        sort(temp);
        System.out.println(Arrays.toString(temp));
    }
}
