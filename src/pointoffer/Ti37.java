package pointoffer;

import org.junit.Test;

/**
 *
 * 统计一个数字在排序数组当中出现的次数
 *
 * Created by Ericwyn on 18-9-17.
 */
public class Ti37 {

    /**
     *
     * 运行时间：25ms
     * 占用内存：9292k
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0){
            return 0;
        }
//        int count = 0;
//        for (int i=0;i<array.length;i++){
//            if (array[i] == k){
//                count++;
//            }
//        }
//        return count;
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while (end >= start){
            mid = (end-start)/2 + start;
            if (array[mid] > k){
                end = mid-1;
            }else if (array[mid] < k){
                start = mid + 1;
            }else {
                break;
            }
        }
        int startTemp = mid;
        int endTemp = mid;
        System.out.println("mid:"+mid);
        while (startTemp >= 0 && array[startTemp] == k){
            startTemp--;
        }
        while (endTemp < array.length && array[endTemp] == k){
            endTemp++;
        }
        startTemp++;    // 开始位置
        endTemp--;      // 结束位置
        // 如果不存在的话，endTemp - startTemp + 1 = -1;
        // 如果不存在的话，endTemp = 0-- = -1, startTemp = 0++ = 1, 所以返回的值是 -1
        return (endTemp-startTemp+1)>0?(endTemp-startTemp+1):0;
    }

    @Test
    public void test(){
//        int[] nums = new int[10000];
//        for (int i=0;i<nums.length;i++){
//            nums[i] = 10000;
//        }
        System.out.println(GetNumberOfK(new int[]{3,3,3,3,4,5},2));
//        System.out.println(GetNumberOfK(nums,3));

    }
}
