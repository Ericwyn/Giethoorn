package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 *      插入排序的含义是，将一个长度为 n 的队列，看成 2 个队列，一个有序队列，一个无序队列
 *      一开始的时候，有序队列长度为 1 个，无序队列长度为 n-1
 *      然后每次从无序队列里面选一个出来，插入到有序队列当中，知道无序队列的长度变为 0
 *
 * 双重循环，时间复杂度 n^2
 *
 * Created by Ericwyn on 18-6-4.
 */
public class InsertSort {
    public void sorting(int[] nums){
        if (nums == null || nums.length<2){
            return;
        }
        // 遍历无序队列, 无序队列从 i ~ n
        for (int i=1; i<nums.length; i++){
            // 取出无序队列的第一个作为待插入数字
            int j = i-1;
            int insertData = nums[i];
            // 从有序队列当中寻找合适的位置
            // 从有序队列的最后一个开始，如果这个位置的值是大于这个 insertData 的
            // 那么这个位置的数字就往后面（右边）移动
            while ((j >= 0) && (nums[j] >= insertData)){
                nums[j+1] = nums[j];
                j--;
            }
            // 这里不是 nums[j] 而是 nums[j+1] ，因为上面的 j-- 在最后的时候也会执行
            nums[j+1] = insertData;
        }
    }

    @Test
    public void test(){
        int[] test =  new int[]{5,4,2,7,6,1,8,3,9,0};
        sorting(test);
        System.out.println(Arrays.toString(test));
    }

}
