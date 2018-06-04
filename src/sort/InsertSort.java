package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 直接插入排序
 * 双重循环，时间复杂度 n^2
 *
 * Created by Ericwyn on 18-6-4.
 */
public class InsertSort {
    public void sorting(int[] nums){
        if (nums == null || nums.length < 2)
            return;

        int i, j, insertData;
        for (i = 1; i < nums.length; i++) {
            insertData = nums[i];// 要插入的变量

            // 只要比 insertData 大的数据，都往右移
            for (j = i - 1; j >= 0 && insertData < nums[j]; j--){
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = insertData;// 将要插入的数据放置到正确的位置
        }
    }

    @Test
    public void test(){
        int[] test =  new int[]{5,4,2,7,6,1,8,3,9,0};
        sorting(test);
        System.out.println(Arrays.toString(test));
    }

}
