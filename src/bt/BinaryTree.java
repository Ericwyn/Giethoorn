package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树相关知识
 *
 * Created by Ericwyn on 18-5-21.
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public List preorder(){
        ArrayList res = new ArrayList<>();
        prorderTemp(this.root,res);
        return res;
    }

    /**
     * 先序遍历
     * @param root
     * @param res
     */
    private void prorderTemp(TreeNode root, List res){
        if (root!=null){
            res.add(root.getDate());
            prorderTemp(root.getLeft(),res);
            prorderTemp(root.getRight(),res);
        }
    }


    public List inorder(){
        ArrayList res = new ArrayList<>();
        inorderTemp(this.root,res);
        return res;
    }

    /**
     * 中序遍历
     * @param root
     * @param res
     */
    private void inorderTemp(TreeNode root, List res){
        if (root!=null){
            inorderTemp(root.getLeft(),res);
            res.add(root.getDate());
            inorderTemp(root.getRight(),res);
        }
    }


    public List postorder(){
        ArrayList res = new ArrayList<>();
        postorderTemp(this.root,res);
        return res;
    }

    /**
     * 后序遍历
     * @param root
     * @param res
     */
    private void postorderTemp(TreeNode root, List res){
        if (root!=null){
            postorderTemp(root.getLeft(),res);
            postorderTemp(root.getRight(),res);
            res.add(root.getDate());
        }
    }

    /**
     * 二叉树的层序遍历
     * @return
     */
    public List<TreeNode> level(){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> res = new ArrayList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()){
            TreeNode nodeintemp = queue.poll();
            if (nodeintemp.getLeft()!=null){
                queue.offer(nodeintemp.getLeft());
            }
            if (nodeintemp.getRight()!=null){
                queue.offer(nodeintemp.getRight());
            }
            res.add(nodeintemp);
        }
        return res;
    }

    //获取节点的数量
    public int getNodeNum(){
        return getNodeNum(this.root);
    }

    /**
     * 求二叉树的节点数量
     * @param root
     * @return
     */
    private int getNodeNum(TreeNode root){
        if (root == null){
            return 0;
        }else {
            return getNodeNum(root.getLeft())+getNodeNum(root.getRight())+1;
        }
    }

    private int getDeepth(){
        return getDeepth(this.root);
    }

    /**
     * 求二叉树的深度
     * @param root
     * @return
     */
    private int getDeepth(TreeNode root){
        if (root == null){
            return 0;
        } else {
            int rigthDeepth = getDeepth(root.getRight());
            int leftDeepth = getDeepth(root.getLeft());
            return rigthDeepth>leftDeepth?rigthDeepth:leftDeepth;
        }
    }


    public int getLevelKCount(int k){
        return getLevelKCount(this.root,k);
    }

    /**
     * 求第 k 层节点的个数
     *
     * 当 k 为 1 的时候，遍历已经去到第 k 层了，这个时候每个节点都返回 1，加起来自然就是第 k 层的节点数量
     *
     * @param k
     * @return
     */
    public int getLevelKCount(TreeNode root, int k){
        if ( root == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return getLevelKCount(root.left,k-1)+getLevelKCount(root.right,k-1);
    }


    public int getLeafNodeCount(){
        return getLeafNodeCount(this.root);
    }

    /**
     * 寻找一棵树的叶子节点的数量
     *
     * 叶子的特征：
     *      不为空
     *      左子树为空
     *      右子树为空
     *
     * 使用递归，看看是否遇到是叶子特征的节点，否则的话就继续递归下去
     *
     * @param root
     * @return
     */
    private int getLeafNodeCount(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.getRight() == null && root.getLeft() == null){
            return 1;
        }
        return getLeafNodeCount(root.getRight())+getLeafNodeCount(root.getLeft());
    }


    public boolean equals(BinaryTree tree){
        return equals(this.root,tree.root);
    }

    /**
     * 判断两棵树是否相等的算法
     *
     * 递归的结束条件
     *      如果两者都为空了，证明两者在同一条路径上都到底了，所以返回 true
     *      如果只有当中一个为空，那么证明还有一条路径没有到最末尾，返回 false
     *      否则的话
     *      就判断是否值相等，（判断数值是否相等）
     *      再判断剩下的结构是否相等，（递归遍历两者的左子树和右子树是否分别相等）
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean equals(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }else if (root1 == null || root2 == null) {
            return false;
        }
        return root1.date == root2.date             //如果不考虑数值相等，只考虑结构上的相等，把这一行去掉就是了
                && equals(root1.getLeft(), root2.getLeft())
                && equals(root1.getRight(), root2.getRight());
    }


    public boolean hasChilTree(BinaryTree tree){
        return hasChilTree(this.root,tree.root);
    }

    /**
     * 判断是否是另一棵二叉树的子树
     * 借助于判断二叉树是否相等的方法
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean hasChilTree(TreeNode root1, TreeNode root2){
        //在需找到相等了之后
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.getDate() == root2.getDate()){
            return hasChilTreeTemp(root1,root2);
        }else {
            //否则的话就递归下去寻找以后的节点
            return hasChilTree(root1.left,root2)
                    || hasChilTree(root1.right,root2);
        }
    }

    /**
     * 这个方法和判断二叉树相等的 equals 方法有点像
     * 但是递归的结束条件不一样
     * 这个方法判断的是，root1 是否包含 root2
     *
     * 所以当 root2 == null 的时候证明已经完全完结了
     * root2 已经能在 root1 里面找到某条路径的全部对应，这时候就能返回 true
     * 至于 root1 是否是这条路径上的最末尾，并不用去理会
     * 但是，当 root1 已经为 null ，但是 root2 还不为 null 的时候
     * 就说明无法匹配，一定是返回 false
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean hasChilTreeTemp(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 != null){
            return false;
        }else if (root2 == null) {
            return true;
        }
        return root1.date == root2.date             //如果不考虑数值相等，只考虑结构上的相等，把这一行去掉就是了
                && hasChilTreeTemp(root1.getLeft(), root2.getLeft())
                && hasChilTreeTemp(root1.getRight(), root2.getRight());
    }

    public void mirror(){
        mirror(this.root);
    }

    /**
     * 二叉树的镜像翻转
     * 不断递归翻转左右子树就可以了
     *
     * @param root
     */
    private void mirror(TreeNode root){
        if (root!=null && root.getLeft()!=null && root.getRight()!=null){
            TreeNode temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
            mirror(root.getRight());
            mirror(root.getLeft());
        }
    }

    /**
     * 判断二叉树是否是平衡二叉树
     */


    public static BinaryTree generateBinaryTree(String preorder,String inorder){
        TreeNode root = generateBinaryTreeTemp(preorder,inorder);
        return new BinaryTree(root);
    }

    /**
     * 通过先序遍历和后序遍历结果，生成一棵二叉树
     *
     * 先序遍历的头个数字就是根节点，
     * 然后以根节点作为分割，将中序遍历切成两份，左边的是左子树的中序遍历，右边是右子树的中序遍历结果
     * 以左右子树的中序遍历的长度来从先序遍历当中拿到左右子树的先序遍历
     *
     * 然后再递归传入左右子树的先序遍历、中序遍历，再来分别创建左右子树
     *
     * 递归的结束条件
     *      如果先序遍历和中序遍历结果为 "" ，那么返回 null
     *          其实之所以会有出现先序遍历和中序遍历都为 "" 的这种情况，是因为 java 的 split 函数的问题
     *          "AB".split("A") = { "", "B" }
     *          "AB".split("B") = { "A" }
     *      如果先序遍历和中序遍历结果长度都为1，那么直接返回一个 TreeNode 就好了
     *
     *      否则的话，使用先序遍历的首位，来构建一个节点，然后节点的左右节点使用新的先序遍历和中序遍历来生成
     */
    public static TreeNode generateBinaryTreeTemp(String preorder,String inorder){
        if (preorder == null || preorder.equals("") || preorder.length() != inorder.length()){
            return null;
        }
        if (preorder.length() == 1){
            return new TreeNode(Integer.parseInt(preorder));
        }
        String rootNum = ""+preorder.charAt(0);
        TreeNode root = new TreeNode(Integer.parseInt(rootNum));
        String[] inorderTemp = inorder.split(rootNum);
        String leftInorder = inorderTemp[0];
        String rightInoeder = "";
        if (inorderTemp.length>1){
            rightInoeder = inorderTemp[1];
        }
        String leftPreorder = preorder.substring(1,leftInorder.length()+1);
        String rightPreorder = preorder.substring(1+leftInorder.length(),preorder.length());
        root.setLeft(generateBinaryTreeTemp(leftPreorder,leftInorder));
        root.setRight(generateBinaryTreeTemp(rightPreorder,rightInoeder));
        return root;
    }



    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int date;

        public TreeNode(int date, TreeNode left, TreeNode right){
            this.date = date;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int date){
            this.date = date;
            this.left = left;
            this.right = right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDate() {
            return date;
        }
    }
}
