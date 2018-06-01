package pointoffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * ----------------------------
 *
 * 第一个想法就是，直接中序遍历，然后存储到一个　List 里面
 *
 * Created by Ericwyn on 18-6-1.
 */
public class Ti26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 运行时间：16ms
    // 占用内存：9456k
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> tempList = new ArrayList<>();
        inorderTemp(pRootOfTree,tempList);
        for (int i=0;i<tempList.size();i++){
            if (i == 0){
                if (i+1<tempList.size()){
                    tempList.get(i).right = tempList.get(i+1);
                }
            }else if (i==tempList.size()-1){
                if (i-1>=0){
                    tempList.get(i).left = tempList.get(i-1);
                }
            }else {
                if (i+1<tempList.size()){
                    tempList.get(i).right = tempList.get(i+1);
                }
                if (i-1>=0){
                    tempList.get(i).left = tempList.get(i-1);
                }
            }
        }
        return tempList.get(0);
    }

    public void inorderTemp (TreeNode root,ArrayList<TreeNode> tempList){
        if (root.left!=null){
            inorderTemp(root.left,tempList);
        }
        tempList.add(root);
        if (root.right!=null){
            inorderTemp(root.right,tempList);
        }
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode convert = Convert(root);
        System.out.println(convert);

    }
}
