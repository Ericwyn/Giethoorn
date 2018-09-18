package pointoffer;

import org.junit.Test;

/**
 * Created by Ericwyn on 18-9-14.
 */
public class Ti40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        for (int i=1;i<array.length;i++){
            System.out.println(temp +" ^ " + array[i] +" = " + (temp ^ array[i]));
            temp = temp ^ array[i];
        }
    }

    @Test
    public void test(){
        FindNumsAppearOnce(new int[]{1,1,2,2,3,4,4,6,6,7,8,8},new int[1], new int[1]);
        System.out.println(3^7);
    }
}
