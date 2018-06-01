package pointoffer;

import org.junit.Test;

/**
 *
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,
 * 否则输出No。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * -----------------------------------------
 *
 * 后续遍历的一个很关键的点在于，最末尾的数字是根节点
 * 而由于是二叉搜索树，所以根节点一定会在前面的序列中找到某个位置
 * 使得这个位置之前的数字都小于根节点而这个位置之后的数字都大于根节点
 * 然后递归分割，分割出来的又是一个后序遍历序列
 *
 * Created by Ericwyn on 18-6-1.
 */
public class Ti23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null){
            return false;
        }
        if (sequence.length == 1){
            return true;
        }
        boolean flag = false;
        int mo = sequence[sequence.length-1];
        int fenGe = -1;
        for (int i=0;i<sequence.length;i++){
            boolean flagQian = true;
            for (int j=0;j<i;j++){
                if (sequence[j]>mo){
                    flagQian = false;
                    break;
                }
            }
            //前面的序列都符合小于 mo ，在进行后面的遍历
            if (flagQian){
                boolean flagHou = true;
                for (int j=i;j<sequence.length-1;j++){
                    if (sequence[j]<mo){
                        flagHou = false;
                        break;
                    }
                }
                if (flagHou){
                    flag = true;
                    fenGe = i;
                    break;
                }
            }
        }
        if (flag){
            int[] arrayQian;
            int[] arrayHou;
            arrayHou = new int[sequence.length-fenGe-1];
            System.arraycopy(sequence,fenGe,arrayHou,0,sequence.length-fenGe-1);
            if (fenGe <= 1){
                arrayQian = null;
                return VerifySquenceOfBST(arrayHou);
            }else {
                arrayQian = new int[fenGe];
                System.arraycopy(sequence,0,arrayQian,0,fenGe);
                return VerifySquenceOfBST(arrayQian) && VerifySquenceOfBST(arrayHou);
            }
        }else {
            return false;
        }
    }

    @Test
    public void test(){
        System.out.println( VerifySquenceOfBST(new int[]{}));
        System.out.println( VerifySquenceOfBST(new int[]{5,4,3,2,1}));
        System.out.println( VerifySquenceOfBST(new int[]{1,4,8,6,3,13,14,10,8}));

    }

}
