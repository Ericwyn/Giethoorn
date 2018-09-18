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
 * 二叉搜索树定义：左孩子比父节点小，右孩子比父节点大，”中序遍历“可以让结点有序。
 *
 * ----------------------------
 *
 * 第一个想法就是，直接中序遍历，然后存储到一个　List 里面
 * 这个方法能够 ac 但是会付出存储成本
 *
 * ----------------------------
 *
 * 正常的方法应该是，
 * 1，root 节点与左子树的最右节点建立绑定
 * 2，root 节点与右子树的最左节点建立绑定
 *
 * 以左子树和右子树的最顶部节点为 root ，然后递归
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
    public TreeNode convert(TreeNode pRootOfTree) {
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


    /**
     * 正解
     *
     * @param pRootOfTree
     */
    public void Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return;
        }
        TreeNode rootLeft = pRootOfTree.left;
        if (rootLeft != null){
            TreeNode leftMost = toRightmost(rootLeft);
            leftMost.right = pRootOfTree;
            pRootOfTree.left = leftMost;
            if (leftMost != rootLeft){
                Convert(rootLeft);
            }
        }

        TreeNode rootRight = pRootOfTree.right;
        if (rootRight != null){
            TreeNode rightMost = toLeftmost(rootRight);
            rightMost.left = pRootOfTree;
            pRootOfTree.right = rightMost;
            if (rightMost != rootRight){
                Convert(rootRight);
            }
        }
    }

    private TreeNode toLeftmost(TreeNode root){
        TreeNode temp = root;
        while (temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    private TreeNode toRightmost(TreeNode root){
        TreeNode temp = root;
        while (temp.right != null){
            temp = temp.right;
        }
        return temp;
    }


    @Test
    public void test(){
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        TreeNode convert = convert(root);


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        Convert(root);
        System.out.println(root);

    }
}
