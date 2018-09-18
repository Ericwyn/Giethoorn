package pointoffer;

/**
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树的定义：如果某二叉树中任意结点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 *
 * Created by Ericwyn on 18-9-18.
 */
public class Ti39 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归写法
     *
     * 递归的话，时间复杂度为 n^2，因为要给 n 个节点计算子节点的数量
     *
     * 运行时间：31ms
     * 占用内存：9084k
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution2(TreeNode root) {

        if (root == null){
            return true;
        }
        // 计算左右子树的差值
        int count = countDepth(root.right) - countDepth(root.left);
        // 差值大于 1 返回 false
        if (count <-1 || count>1){
            return false;
        }else {
            // 因为当 root == null 的时候，返回 true ，
            // 所以只有当左右子树同时为 null 的时候这里才递归结束返回 true
            // 也就是当 root 为叶子节点的时候返回 true
            return IsBalanced_Solution2(root.right) && IsBalanced_Solution2(root.left);
        }
    }

    /**
     *
     * 非递归写法，使用后序遍历，左节点-右节点-根节点，遍历根节点之前已经遍历完了左右节点了
     *
     * 可以通过后序遍历来记录左右节点的数量
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root, Integer depth) {
        if(root == null){
            depth = 0;
            return true;
        }
        int left = 0,right = 0;
        if(IsBalanced_Solution(root.left,left) && IsBalanced_Solution(root.right,right)){
            int diff = left-right;
            if(diff <= 1 && diff >= -1){
                depth = 1+(left > right?left : right);
                return true;
            }
        }
        return false;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalanced_Solution(root,0);
    }

    public void temp(TreeNode root){
        if (root != null){
            if (root.left != null){
                temp(root.left);
            }
            if (root.right != null){
                temp(root.right);
            }
            System.out.println(root.val);
        }
    }

    // 求二叉树的深度
    public int countDepth(TreeNode root){
        if (root == null){
            return 0;
        }else {
            int left;
            int right;
            return (left = countDepth(root.left)+1)>(right = countDepth(root.right)+1)?left:right;
        }
    }

}
