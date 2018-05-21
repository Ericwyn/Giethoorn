package pointoffer;

/**
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * Created by Ericwyn on 18-5-18.
 */
public class Ti17 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        // 只有当有一个相同了才开始遍历
        if (root1.val == root2.val){
            //这样的话，只会比较 1 个节点（因为只要有某个节点是一样的，就一定会有固定返回值了）
//            return doesTree1HaveTree2(root1,root2);
            result = doesTree1HaveTree2(root1,root2);
        }
        // 没找到的话，找左边
        if (!result){
            result = HasSubtree(root1.left,root2);
        }
        // 还没找到的话，找右边
        if (!result){
            result = HasSubtree(root1.right,root2);
        }
        return result;
    }


    // 判断 tree2 是否包含在 tree1 里面
    // 成功的条件

    /**
     * 判断 tree2 是否是 tree1 的子树
     *  注意: 他们的根节点是一样的
     *
     * 成功的条件为
     *      1，tree2 为 null 时候，tree1也为 null 或者 tree1 还不为 null
     *      2，在遍历到 tree2 之前的每一个节点，都有 tree1.value == tree2.value
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean doesTree1HaveTree2(TreeNode tree1,TreeNode tree2) {
        // tree1 到底，但是 tree2 没有到底
        if (tree1 == null && tree2 != null) {
            return false;
        }
        // 如果除了上面的那种情况外，tree2 到底了
        // 那么久成功了
        if (tree2 == null) {
            return true;
        }
        //
        return tree1.val == tree2.val
                && doesTree1HaveTree2(tree1.left, tree2.left)
                && doesTree1HaveTree2(tree1.right, tree2.right);

    }
}
