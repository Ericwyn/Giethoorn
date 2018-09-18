package pointoffer;

import org.junit.Test;

/**
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * Created by Ericwyn on 18-9-5.
 */
public class Ti34 {

    /**
     *
     * 运行时间：27ms
     *
     * 占用内存：9560k
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[] count = new int[200];
        for (int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if (count[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test(){
        System.out.println(FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
