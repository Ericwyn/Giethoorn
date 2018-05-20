package pointoffer;

import org.junit.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * 二叉树的层序遍历
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 从前觉得这是很难的东西吧，看了一下才发现一点都不难
 * 先打印根节点，然后开始递归
 *
 * 如果左节点存在的话，打印左节点
 * 如果右节点存在的话，打印右节点
 * 如果左节点存在的话，递归左节点
 * 如果右节点存在的话，递归右节点
 *
 * 然后递归左节点，再递归右节点
 *
 * 好吧这个方法 gg 了
 *
 * --------------------------------------------
 *
 * 新的方法是，使用一个 List<Vector> 来记录每一层，递归的时候加上层数
 * 这个方法管用,但其实还是挺暴力的.... List 占用空间也大
 * 不过这个方法很简单来着,
 *
 * ---------------------------------------------
 * 正儿八经的二叉树层序遍历,是借助队列的
 *
 * Created by Ericwyn on 18-5-20.
 */
public class Ti22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        Vector<Integer> vector = new Vector<>();
//        vector.add(root.val);
//        PrintFromTopToBottom2(vector,root);
//        return new ArrayList<Integer>();
//    }

//    public void PrintFromTopToBottom2(Vector<Integer> vector,TreeNode root) {
//        if (root.left!=null){
//            vector.add(root.left.val);
//            if(root.left!=null){
//                PrintFromTopToBottom2(vector,root.left);
//            }
//        }
//        if (root.right!=null){
//            vector.add(root.right.val);
//            if (root.right!=null){
//                PrintFromTopToBottom2(vector,root.right);
//            }
//        }
//    }


    // 运行时间：17ms
    // 占用内存：9432k
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        PrintFromTopToBottom2(lists,root,0);
        for (ArrayList<Integer> list:lists){
            res.addAll(list);
        }
        return res;
    }

    public void PrintFromTopToBottom2(ArrayList<ArrayList<Integer>> list, TreeNode root,int countNum) {
        if (countNum>=list.size()){
            list.add(new ArrayList<>());
        }
        list.get(countNum).add(root.val);
        countNum++;
        if (root.left!=null){
            PrintFromTopToBottom2(list,root.left,countNum);
        }
        if (root.right!=null){
            PrintFromTopToBottom2(list,root.right,countNum);
        }
    }


    // 正儿八经的层序遍历
    // 压根不需要递归
    // 运行时间：11ms
    // 占用内存：9296k
    public ArrayList<Integer> PrintFromTopToBottom3(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            res.add(poll.val);
        }
        return res;
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        left.left.left=new TreeNode(8);
        left.left.right=new TreeNode(9);
        left.right.left=new TreeNode(10);
        left.right.right=new TreeNode(11);
        right.left.left=new TreeNode(12);
        right.left.right=new TreeNode(13);
        right.right.left=new TreeNode(14);
        right.right.right=new TreeNode(15);

        ArrayList<Integer> list = PrintFromTopToBottom3(root);
        System.out.println(list);
    }

}
