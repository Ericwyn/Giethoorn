package others;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一个值 n , 产生一个随机播放序列从 0 ~ n
 *
 * 简单粗暴的就是随机删掉剩余的队列里面的一个
 *
 * Created by Ericwyn on 18-7-8.
 */
public class RandomList {
    // 返回随机序列
    public ArrayList<Integer>  randomList(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            int randomIndex = (int)(Math.random()*list.size());
            res.add(list.remove(randomIndex));
        }
        return res;
    }

    // 通过产生随机序列来完成排序,不断的产生随机序列从而找到符合规则的那个序列
    // 我觉得这方法可以被称为
    // xjb 排序
    // 10个数字花费大概是 3s
    // 11个数字花费大概是 30 s
    // 12个数字花费大概是 205 s
    @Test
    public void test(){
        long sTime = System.currentTimeMillis();

        ArrayList<Integer> integers;
        long time =0;
        boolean sortFlag;
        for (;;){
            integers  = randomList(12);
            time++;
            sortFlag = true;
            for (int i=0;i<integers.size()-1;i++){
                if (integers.get(i)>integers.get(i+1)){
                    sortFlag = false;
                    break;
                }
            }
            if (sortFlag){
                System.out.println(integers);
                break;
            }
        }

        System.out.println("use "+time+" times to sort");
        System.out.println("use time : "+(System.currentTimeMillis()-sTime)/1000);
    }

    // 多线程完成的 xjb 排序
    // 完成 10 个数字的排序
    // 1s           1855943 times
    // 2.266s       3128691 times
    // 完成 11 个数字的排序
    // 17.463s      24354616 times
    // 33.952s      47234629 times
    // 180.68 s     242458228 times
    // 发现多线程对这个算法的运行,没有任何加速作用......
    private static long timeForMultiThread  = 0;
    private static boolean continueFlag = true;
    private static int sortNum = 12;
    @Test
    public void test2(){
        long sTime = System.currentTimeMillis();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> integers;
                for (;;){
                    if (!continueFlag){
                        break;
                    }
                    timeForMultiThread ++;
                    if (isSort((integers = randomList(sortNum)))){
                        System.out.println(integers);
                        continueFlag = false;
                        System.out.println("use "+timeForMultiThread+" times to sort");
                        System.out.println("use time : "+1.0*(System.currentTimeMillis()-sTime)/1000+" s");
                        break;
                    }
                }
            }
        };
        new Thread(runnable).run();
        new Thread(runnable).run();
        new Thread(runnable).run();
        new Thread(runnable).run();
    }

    public boolean isSort(ArrayList<Integer> list){
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

}
