package pointoffer;

import org.junit.Test;

/**
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 * 是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *
 * 例如:
 *
 *      {6,-3,-2,7,-15,1,2,2}
 *
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。也就是 {6,-3,-2,7}
 *
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * Created by Ericwyn on 18-9-2.
 */
public class Ti30 {

    /**
     *
     * 运行时间：21ms
     * 占用内存：9304k
     *
     * 暴力的方法，直接计算所有累加结果的和
     *
     * PS：这里对题目理解错了
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int countTemp;
        int maxTemp;
        int maxRes = -1000000000;
        for (int i=0;i<array.length;i++){
            countTemp = 0;
            maxTemp = -1000000000;
            int j=i;
            while (j<array.length){
                countTemp+=array[j];
                if (countTemp>maxTemp){
                    maxTemp = countTemp;
                }
                j++;
            }
            if (maxTemp > maxRes){
                maxRes = maxTemp;
            }
        }
        return maxRes;
    }

    /**
     *
     * 时间复杂度O（n）
     * 和最大的子序列的第一个元素肯定是正数
     * 因为元素有正有负，因此子序列的最大和一定大于0
     *
     * 带有局限性，数组最少要有一个大鱼等于 0
     *
     * @param arr
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] arr){
        int i;
        int MaxSum = 0;
        int CurSum = 0;
        for(i=0;i<arr.length;i++) {
            CurSum += arr[i];
            if(CurSum > MaxSum){
                MaxSum = CurSum;
            }
            //如果累加和出现小于0的情况，
            //则和最大的子序列肯定不可能包含前面的元素，
            //这时将累加和置0，从下个元素重新开始累加
            if(CurSum < 0){
                CurSum = 0;
            }
        }
        return MaxSum;
    }


    @Test
    public void test(){
        System.out.println(FindGreatestSumOfSubArray(new int[]{-3,0,-3}));
    }
}
