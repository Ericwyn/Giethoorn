package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * Created by Ericwyn on 18-9-1.
 */
public class Ti27 {
    /**
     *
     * 运行时间：123ms
     * 占用内存：12140k
     *
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?toCommentId=1740010
     * 来源：牛客网
     *
     * 将 str 看成两个部分，前半部分是已经定下来了的，后半部分是可以随机选择一个加入到前半部分当中的
     * 当后半部分只剩下一个的时候，证明两个部分只能组成一个新字符串了，于是将这个生成的字符串加入到 set 当中（ set 是为了去重），递归完成
     * 然后将 set 转成 list ，顺手再排个序
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        HashSet<String> set = new HashSet<>();
        temp("", str, set);
        ArrayList<String> res =  new ArrayList<>(set);
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    public void temp(String qian, String hou, HashSet<String> set){
        if (hou.length() == 1){
            set.add(qian+hou);
        }else {
            for (int i = 0; i < hou.length(); i++){
                temp(qian+hou.charAt(i), hou.substring(0,i)+hou.substring(i+1), set);
            }
        }
    }

    @Test
    public void test(){
        List<String> list = Permutation("aab");
        for (String str:list){
            System.out.println(str);
        }
    }
}
