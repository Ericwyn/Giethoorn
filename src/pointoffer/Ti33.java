package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 *
 *      6 = 2 * 3
 *      8 = 2 * 2 * 2
 *
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * Created by Ericwyn on 18-9-3.
 */
public class Ti33 {

    /**         2 * 2
     *          2 * 3
     *          2 * 5
     *      2   3 * 2
     * 1    3   3 * 3
     *      5   3 * 5
     *          5 * 2
     *          5 * 3
     *          5 * 5
     *
     * 所以其实就是一颗打横的树，我们需要的就是树的层序遍历就好了
     *
     * 然后翻车了，因为这样的话并不会按顺序....
     *
     * 1，2，3，5，4，6，10，6，9，15......
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 1){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Integer temp = -1;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            temp = queue.peek();
//            set.add(temp);
//            if (set.size() == index){
//                break;
//            }else {
//                queue.offer(temp*2);
//                queue.offer(temp*3);
//                queue.offer(temp*5);
//            }
            Integer temp1 = temp*2;
            Integer temp2 = temp*3;
            Integer temp3 = temp*5;
            queue.offer(temp1);
            queue.offer(temp2);
            queue.offer(temp3);
            set.add(temp1);
            set.add(temp2);
            set.add(temp3);
            if (set.size() >= index){
                break;
            }
            queue.poll();
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return list.get(index-1);
    }

    @Test
    public void test(){
        System.out.println(GetUglyNumber_Solution(1000));
    }
}
