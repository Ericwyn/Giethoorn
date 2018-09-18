package pointoffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 *
 * 则最小的4个数字是1,2,3,4,。
 *
 * Created by Ericwyn on 18-9-1.
 */
public class Ti29 {
    /**
     * 第一个思路
     * 快排然后直接取前面的 k 个
     *
     * 运行时间：22ms
     * 占用内存：9520k
     *
     * 但是实际上并不需要全部排序，求最小的几个，就直接用最小堆排序就好了
     *
     * 堆排序，复杂度是o(nlogn)，比较稳定适合大数据量的排序
     *
     * 如果是快排的话分的不均匀容易引起，复杂度是o（n^2）,快排的话大数据量容易引起OOM
     *
     *
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k>input.length){
            return new ArrayList<>();
        }
        quickSort(input, 0, input.length-1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int j = partition(nums, left, right);
        quickSort(nums, left, j-1);
        quickSort(nums, j+1, right);
    }

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
            while (i < j && nums[i] < tmp){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = tmp;
        return i;
    }

    @Test
    public void test(){
        System.out.println(GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4));
    }
}
