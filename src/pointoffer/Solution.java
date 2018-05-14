package pointoffer;

import org.junit.Test;

/**
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 *
 * 当前位置 row，col，指向当前矩阵的最右上角
 * 然后从矩阵的右上角开始，一步步缩小 target 可能在的范围的矩阵
 * 如果与 [row, col] 相等，直接输出 true
 * 如果比 [row, col] 的数字小的话， col --，矩阵减小左右边一列
 * 如果比 [row, col] 的数字大的话， row ++,矩阵减小最上面的一行
 * 直到便利完整个矩阵，都无法
 *
 * Created by Ericwyn on 18-4-24.
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean isFind = false;
        int rows = array.length;
        int colums = array[0].length;
        int row = 0;
        int col = array[0].length-1;
        while (row < rows && col >= 0){
            if (array[row][col] == target){
                isFind = true;
                break;
            }else if (array[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return isFind;
    }

    @Test
    public void test(){
        int[][] matrix = {
                { 1, 2, 8, 9 },
                { 2, 4, 9, 12 },
                { 4, 7, 10, 13 },
                { 6, 8, 11, 15 }
        };

        System.out.println(Find(12,matrix));
    }

}
