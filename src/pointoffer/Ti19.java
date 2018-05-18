package pointoffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 *
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 *              1   2   3   4
 *              5   6   7   8
 *              9   10  11  12
 *              13  14  15  16
 *
 * 则依次打印出数字
 *              1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *
 * 第一个思路是通过判断所处的位置来确定执行过程，例如处在左上角或者右上角
 * 然后已经遍历过的位置统一设置为某个 flag
 *
 * 然后这样做好像很麻烦....因为例如当上面的矩阵，剩下 7、11、10 的时候，7的左边右边上边就全部是0了，很难判断
 *
 * 第二个思路是递归
 *
 * 写一个函数，打印矩阵最外面的那一圈，带上变长，从矩阵的左上角开始，一直打印到右下角
 *          然后自己写这个函数的时候翻车了，太复杂了总是会越界
 *          然后预想的也是正方形，没有针对矩形的情况处理
 *          后面借鉴答案的做法，定义4个变量来规定上下左右的距离
 *          毕竟在打印某一条边的时候，总有2个变量是不变的但是2个变量是变化的
 *
 *
 * Created by Ericwyn on 18-5-18.
 */
public class Ti19 {

    // 测试没有什么问题啊
    // 但是这种写法一直超时 ，我很无奈
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int aX = 0;   // 左上 x
        int aY = 0;    // 左上 y
        int bX = matrix.length-1; //右下 x
        int bY = matrix[0].length-1;    //右下 y
        while (res.size()!=matrix.length*matrix[0].length){
            // 左上到右上 ax,ay 到 bx,ay
            for (int i=aY;i<bY;i++){
                res.add(matrix[aX][i]);
            }
            for (int i=aX;i<bX;i++){
                res.add(matrix[i][bY]);
            }
            for (int i=bY;i>aY;i--){
                res.add(matrix[bX][i]);
            }
            for (int i=bX;i>aX;i--){
                res.add(matrix[i][aY]);
            }
            aX++;aY++;bX--;bY--;
        }
        return res;
    }

//    /** 失败了
//     * 打印 矩阵 matrix，以 [a,b] 为左上顶点的正方形矩阵的最外面拿圈
//     * @param matrix
//     * @param a
//     * @param b
//     * @param i
//     */
//    public void printOut(int[][] matrix,int a,int b,int i){
//        if (i==1){
//            System.out.print(matrix[a][b]);
//            System.out.print(",");
//            return;
//        }
//        for (int t=b;t<=b+(i-2);t++){
//            System.out.print(matrix[a][t]);
//            System.out.print(",");
//        }
//        for (int t = a;t<=a+(i-2);t++){
//            System.out.print(matrix[t][b+(i-1)]);
//            System.out.print(",");
//        }
//        for (int t = b+(i-1);t>=b+1;t--){
//            System.out.print(matrix[a+(i-2)][t]);
//            System.out.print(",");
//        }
//        for (int t = a+(i-2);t>=a+1;t--){
//            System.out.print(matrix[t][b]);
//            System.out.print(",");
//        }
//    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
        };

        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.size());
    }
}
