package pointoffer;

/**
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 这道题的第一个思路是写一个函数，交换他的左右子树
 * 然后如果子树不为 null 就递归继续执行
 *
 * 思路正确，一次 AC
 * Created by Ericwyn on 18-5-18.
 */
public class Ti18 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 运行时间：23ms
    // 占用内存：9540k
    public void Mirror(TreeNode root) {
        // 本身不为空且左右子树有一个不为空
        if (root != null && (root.left!=null || root.right!=null)){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left!=null){
                Mirror(root.left);
            }
            if (root.right!=null){
                Mirror(root.right);
            }
        }
    }
}
