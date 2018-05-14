package job;

import org.junit.Test;

import java.util.HashMap;

/**
 *
 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。

 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。

 若没有金额超过总数的一半，返回0。

 测试样例：
 [1,2,3,2,2],5
 返回：2

 *
 * Created by Ericwyn on 18-5-14.
 */
public class Ten_Gifts {
    public int getValue(int[] gifts, int n) {
        // write code here
        // <数字，出现的次数>
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer temp = null;
        for (int i:gifts){
            if ((temp = map.get(i))!=null){
                map.put(i,temp+1);
            }else {
                map.put(i,1);
            }
        }
        int maxTemp = 0;    //最大的数字
        int maxCount = 0;   //最大的数字的数量
        for (Integer key:map.keySet()){
            if ((temp = map.get(key))>maxCount){
                maxCount = temp;
                maxTemp = key;
            }
        }
        if (maxCount > gifts.length/2){
            return maxTemp;
        }
        return 0;
    }

    @Test
    public void test(String[] args) {
        getValue(new int[]{1,2,3,2,2},5);
    }
}
