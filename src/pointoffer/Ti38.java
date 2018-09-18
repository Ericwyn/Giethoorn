package pointoffer;

/**
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * Created by Ericwyn on 18-9-14.
 */
public class Ti38 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     *
     * 运行时间：19ms
     * 占用内存：9324k
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int left;
            int right;
            return (left = TreeDepth(root.left)+1)>(right = TreeDepth(root.right)+1)?left:right;
        }

    }

}
