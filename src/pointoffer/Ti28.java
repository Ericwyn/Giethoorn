package pointoffer;

import org.junit.Test;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * Created by Ericwyn on 18-9-1.
 */
public class Ti28 {
    /**
     *
     * 第一直觉，用 map 存次数
     *
     * 运行时间：18ms
     * 占用内存：9240k
     *
     * 然而看大家的代码，都是 10 ms 内....所以我的时间多了一倍 ....
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int flag = array.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer a:array){
            if (map.get(a) != null){
                map.put(a,(map.get(a)+1)) ;
            }else {
                map.put(a,1) ;
            }
        }
        for (Integer key:map.keySet()){
            if (map.get(key) > flag){
                return key;
            }
        }
        return 0;
    }

    // 另一个思路是：先排序，然后判断


    @Test
    public void test(){
        int a = MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2});
        System.out.println(a);
    }
}
