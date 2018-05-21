package bt;

import org.junit.Test;

/**
 * Created by Ericwyn on 18-5-21.
 */
public class BTTest {
    /**
     * 二叉树如下
     *                  1
     *                /    \
     *             2        3
     *           /  \      /   \
     *         4    5     6     7
     *
     *       / \   / \   / \   / \
     *     8   9 10  11 12 13 14 15
     *
     */
    @Test
    public void test() {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1,null,null);
        BinaryTree.TreeNode current = root;
        current.setLeft(new BinaryTree.TreeNode(2,null,null));
        current.setRight(new BinaryTree.TreeNode(3,null,null));
        BinaryTree.TreeNode left = current.getLeft();
        BinaryTree.TreeNode right = current.getRight();
        current = left;
        current.setLeft(new BinaryTree.TreeNode(4,null,null));
//        current.getLeft().setLeft(new BinaryTree.TreeNode(8,null,null));
//        current.getLeft().setRight(new BinaryTree.TreeNode(9,null,null));
        current.setRight(new BinaryTree.TreeNode(5,null,null));
//        current.getRight().setLeft(new BinaryTree.TreeNode(10,null,null));
//        current.getRight().setRight(new BinaryTree.TreeNode(11,null,null));
        current = right;
        current.setLeft(new BinaryTree.TreeNode(6,null,null));
//        current.getLeft().setLeft(new BinaryTree.TreeNode(12,null,null));
//        current.getLeft().setRight(new BinaryTree.TreeNode(13,null,null));
        current.setRight(new BinaryTree.TreeNode(7,null,null));
//        current.getRight().setLeft(new BinaryTree.TreeNode(14,null,null));
//        current.getRight().setRight(new BinaryTree.TreeNode(15,null,null));

        BinaryTree.TreeNode root2 = new BinaryTree.TreeNode(1,null,null);
        current = root2;
        current.setLeft(new BinaryTree.TreeNode(2,null,null));
        current.setRight(new BinaryTree.TreeNode(3,null,null));
        left = current.getLeft();
        right = current.getRight();
        current = left;
        current.setLeft(new BinaryTree.TreeNode(4,null,null));
//        current.getLeft().setLeft(new BinaryTree.TreeNode(8,null,null));
//        current.getLeft().setRight(new BinaryTree.TreeNode(9,null,null));
        current.setRight(new BinaryTree.TreeNode(5,null,null));
//        current.getRight().setLeft(new BinaryTree.TreeNode(10,null,null));
//        current.getRight().setRight(new BinaryTree.TreeNode(11,null,null));
        current = right;
        current.setLeft(new BinaryTree.TreeNode(6,null,null));
//        current.getLeft().setLeft(new BinaryTree.TreeNode(12,null,null));
//        current.getLeft().setRight(new BinaryTree.TreeNode(13,null,null));
//        current.setRight(new BinaryTree.TreeNode(7,null,null));
//        current.getRight().setLeft(new BinaryTree.TreeNode(14,null,null));
//        current.getRight().setRight(new BinaryTree.TreeNode(15,null,null));


        BinaryTree binaryTree1 = new BinaryTree(root);
        BinaryTree binaryTree2 = new BinaryTree(root2);
        System.out.println("先序遍历："+binaryTree1.preorder());
        System.out.println("中序遍历："+binaryTree1.inorder());
        System.out.println("后序遍历："+binaryTree1.postorder());
        System.out.println("层序遍历："+binaryTree1.level());
//        System.out.println("第 3 层节点数量："+binaryTree1.getLevelKCount(3));
//
//        System.out.println("叶子节点的总数为"+binaryTree1.getLeafNodeCount());

        System.out.println("tree1 与 tree2 相等："+binaryTree1.equals(binaryTree2));
        System.out.println("tree1 包含 tree2 相等："+binaryTree1.hasChilTree(binaryTree2));

    }

    @Test
    public void test2(){
//        String a = "BA";
//        String[] temp = a.split("A");
//        System.out.println(temp.length);

        BinaryTree test = BinaryTree.generateBinaryTree("1243","4213");
        System.out.println(test.level());

    }
}
