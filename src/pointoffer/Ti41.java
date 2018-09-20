package pointoffer;

import java.util.ArrayList;

/**
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * Created by Ericwyn on 18-9-20.
 */
public class Ti41 {

    /**
     *
     * 运行时间：31ms
     * 占用内存：9544k
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int start;
        int end;
        int and;
        for (int i=1;i<sum-1;i++){
            start = i;
            for (int j=i+1;j<=sum;j++){
                end = j;
                and = (start+end) * (end-start+1) / 2;
                if (and > sum || and < sum){
                    continue;
                }else {
                    res.add(retuenList(start,end));
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> retuenList(int start, int end){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=start;i <= end;i++){
            list.add(i);
        }
        return list;
    }

    /*
    思路2

    左神的思路，双指针问题
    当总和小于sum，大指针继续+
    否则小指针+
     */
}
