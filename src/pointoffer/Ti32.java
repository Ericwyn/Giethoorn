package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * Created by Ericwyn on 18-9-2.
 */
public class Ti32 {
    /**
     * 第一个想法是，给他们按照从小到大排序，然后同样长度的子数组里面，我们从小拼接到大
     *
     * 后面发现行不通，{3，32，321} 就是一个很好的示例
     *
     * 然后看了答案发现大家是直接通过字符串排序来做的，而排序的规则不是简单的比大小
     * 而是看 A 和 B 拼接之后的大小
     *
     *      AB < BA 则 A < B
     *      AB > BA 则 A > B
     *      AB = BA 则 A = B
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        int i=0;
        for (int n:numbers){
            strs[i++] = ""+n;
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res = "";
        for (String str:strs){
            res += str;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
}
