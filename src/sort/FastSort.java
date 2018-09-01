package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Ericwyn on 18-8-30.
 */
public class FastSort implements sortting {
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int j = partition(nums, left, right);
        System.out.println(Arrays.toString(nums));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        quickSort(nums, left, j-1);
        quickSort(nums, j+1, right);
    }

    /**
     *
     * 设两个指示i=left，j=right；设arr[left]为基准数
     *
     * 从后向前寻找比基准元素小的元素，填至空位处
     * 从前向后寻找比基准元素大的元素，填至空位处
     *
     * 重复执行2、3步，直到两指示相等，将基准元素填至指示的位置，本次划分结束
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int tmp = nums[i];

        while (i < j){
            while (i < j && nums[j] > tmp){
                j-- ;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            System.out.println(Arrays.toString(nums));
            while (i < j && nums[i] < tmp){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
            System.out.println(Arrays.toString(nums));
            System.out.println("---------------------");
        }
        nums[i] = tmp;
        return i;
    }

    @Test
    public void test(){
        int[] test =  new int[]{5,4,2,7,6,1,8,3,9,0};
        sort(test);
        System.out.println(Arrays.toString(test));
    }

}
