package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * Created by Ericwyn on 18-9-20.
 */
public class Ti42 {
    /**
     * 暴力解决
     *
     * 运行时间：18ms
     * 占用内存：9348k
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Temp> temps = new ArrayList<>();
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] + array[j] > sum){
                    break;
                }else if (array[i] + array[j] == sum){
                    temps.add(new Temp(array[i],array[j]));
                }
            }
        }
        if (temps.size() > 1){
            temps.sort(new Comparator<Temp>() {
                @Override
                public int compare(Temp o1, Temp o2) {
                    return o1.a*o1.b - o2.a*o2.b;
                }
            });
        }
        if (temps.size()>0){
            res.add(temps.get(0).a);
            res.add(temps.get(0).b);
        }
        return res;
    }

        public ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        int sIndex = 0;         // 起始指针
        int eIndex = sIndex+1;  // 结尾指针
        ArrayList<Temp> temps = new ArrayList<>();
        while (eIndex<array.length && sIndex<array.length){
            if (sIndex>=eIndex){
                eIndex++;
            }
            if (array[sIndex]+array[eIndex] > sum){
                eIndex++;
            }else if (array[sIndex] + array[eIndex] < sum){
                sIndex++;
            }else {
                temps.add(new Temp(array[sIndex],array[eIndex]));

            }
        }
        if (temps.size() == 1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(temps.get(0).a>temps.get(0).b?temps.get(0).a:temps.get(0).b);
            list.add(temps.get(0).a<temps.get(0).b?temps.get(0).a:temps.get(0).b);
        }
        return null;
    }

    static class Temp{
        int a;
        int b;

        public Temp(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }

    @Test
    public void test(){
        System.out.println(FindNumbersWithSum(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},21));
    }
}
