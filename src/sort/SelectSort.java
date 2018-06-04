package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 * 双重循环，时间复杂度 n^2
 *
 * Created by Ericwyn on 18-6-4.
 */
public class SelectSort {

    // 选择排序比较好理解
    // 冒泡排序是每次把最大的移动到右边
    // 而选择排序就是把最小的交换到为排序队列的最左边
    public void sorting(int[] nums){
        for (int i=0;i<nums.length;i++){
            // 找出剩下队列里面最小的那个
            int minIndex = i;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            // 交换
            if (minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    @Test
    public void test(){
        int[] test =  new int[]{5,4,2,7,6,1,8,3,9,0};
        sorting(test);
        System.out.println(Arrays.toString(test));
    }

}
