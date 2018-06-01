package pointoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * -------------------------------------
 *
 * 二叉树的深度遍历
 * 主要思路就是找出所有的叶子结点
 * 然后将中途要用什么东西记录叶子节点的经过
 *
 * Created by Ericwyn on 18-6-1.
 */
public class Ti24 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        if (root == null){
//            return new ArrayList<ArrayList<Integer>>();
//        }
////        if (root.right == null && root.left == null || root.val!= target){
////            return new ArrayList<ArrayList<Integer>>();
////        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        ArrayList<String> temp = new ArrayList<>();
//        ArrayList<Integer> numListTemp;
//        FindPathTemp(root,"",temp,0,target);
//        for (String str:temp){
//            numListTemp = new ArrayList<>();
//            String[] num = str.split("->");
//            for (String numTemp:num){
//                numListTemp.add(Integer.parseInt(numTemp));
//            }
//            res.add(numListTemp);
//        }
//        return res;

        FindPathTemp(root,new ArrayList<Integer>(),res);
        return res;
    }

    // 翻车
    public void FindPathTemp(TreeNode root,ArrayList<Integer> pathTemp,ArrayList<ArrayList<Integer>> allPath) {
        //叶子节点，记录
        if (root.left == null && root.right == null){
            pathTemp.add(root.val);
            ArrayList<Integer> clone =  new ArrayList<Integer>();
            clone.addAll(pathTemp);
            allPath.add(clone);
            pathTemp.remove(pathTemp.size()-1);
        }else {
            pathTemp.add(root.val);
            if (root.left!=null){
                FindPathTemp(root.left,pathTemp,allPath);
            }
            if (root.right!=null){
                FindPathTemp(root.right,pathTemp,allPath);
            }
            //超级关键，不加的话就无法获得正确的 path
            pathTemp.remove(pathTemp.size()-1);
        }
    }

    // 运行时间：27ms
    // 占用内存：9548k

    /**
     * 运行时间：27ms
     * 占用内存：9548k
     *
     * @param root 根节点
     * @param pathTemp temp 的路径，用 String 来存储
     *                 保证了不会有 ArrayList 那样的前边遍历过的内容无法清除的问题，
     *                 String 是传值而 List 是传对象
     * @param allPath 保存所有可能路径的 List
     * @param count     当前路径的数字总和，如果数字大于 target 的话就证明不用继续遍历了
     * @param target    目标值
     */
    public void FindPathTemp(TreeNode root,String pathTemp,ArrayList<String> allPath,int count,int target) {
        //叶子节点，记录
        if (root.left == null && root.right == null){
            if (count+root.val == target){
                pathTemp += root.val+"->";
                allPath.add(pathTemp);
            }
        }else {
            if (count+root.val<target){
                pathTemp += root.val+"->";
                count = count+root.val;
                if (root.left!=null){
                    FindPathTemp(root.left,pathTemp,allPath,count,target);
                }
                if (root.right!=null){
                    FindPathTemp(root.right,pathTemp,allPath,count,target);
                }
            }
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(12);

        System.out.println(FindPath(root,22).size());
    }

}
