package source;

import org.junit.Test;

import java.util.HashMap;

/**
 *
 * HashMap 源码的学习
 *
 * Created by Ericwyn on 18-8-11.
 */
public class HashMapS {
    @Test
    public void test(){
        HashMap<String, String> map = new HashMap<>();
        map.put("a","b");
        System.out.println(map.get("a"));
    }
}
