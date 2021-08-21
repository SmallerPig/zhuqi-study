package com.zhuqi.study.netty.LeeCodeSimple;

import java.util.*;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *                  1
 *                 / \
 *                2   2
 *               / \ / \
 *              3  4 4  3
 *             56 7887  65
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 通过次数267,680提交次数499,388
 * @author zhuqi at 2021/2/22
 */
public class Solution0101 {

    public static void main(String[] args){
        Solution0101 solution0101 = new Solution0101();
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return checkRoot(root.left, root.right);
    }

    private boolean checkRoot(TreeNode left, TreeNode right) {
        if (left==null && right == null){return true;}
        if(left== null || right == null){return false;}
        return left.val == right.val
                && checkRoot(left.left, right.right)
                && checkRoot(left.right, right.left);

    }



    public boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    /**
     * 官方迭代法
     * 首先我们引入一个队列，这是把递归程序改写成迭代程序的常用方法。初始化时我们把根节点入队两次。
     * 每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
     * 然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *[1,2,2,3,4,4,3]
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param u
     * @param v
     * @return
     */
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(u);
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     *
     *
     * [3,9,20,null,null,15,7]
     * [1,2,2,3,3,null,null,4,4]
     * [1,2,2,3,null,null,3,4,null,null,4]
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }




    public int maxDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
    }


    /*
    给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。

 

示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 

提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
通过次数182,981提交次数392,014
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

//        int min_depth = Integer.MAX_VALUE;
//        if (root.left != null) {
//            min_depth = Math.min(minDepth(root.left), min_depth);
//        }
//        if (root.right != null) {
//            min_depth = Math.min(minDepth(root.right), min_depth);
//        }
//        return min_depth + 1;


        int left = minDepth(root.left);
        int right = minDepth(root.right);
         if (left == 0){return right+1;}
         if (right ==0){return left+1;}
        return Math.min(left,right)+1;
    }





    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
