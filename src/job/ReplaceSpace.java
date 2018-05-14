package job;

import org.junit.Test;

/**
 *
 * 请实现一个函数，
 * 将一个字符串中的空格替换成“%20”。
 * 例如，
 * 当字符串为
 *      We Are Happy
 * 则经过替换之后的字符串为
 *      We%20Are%20Happy
 *
 * Created by Ericwyn on 18-5-14.
 */
public class ReplaceSpace {

    // 能 AC
    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        int count = 0;
        String qian = "";
        String hou = "";
        String res = str.toString();
        while (count<length){
            if (res.charAt(count)==' '){
                qian = res.substring(0,count);
                hou = res.substring(count+1,length);
                res = qian+"%20"+hou;
                length = res.length();
            }
            count++;
        }
        return res;
    }

    //直接一行代码就能通过了....
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    @Test
    public void test(){
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
