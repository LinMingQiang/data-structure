package com.algorithm.leetcode.tree;

import com.algorithm.leetcode.util.JavaBeanManager.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeSolution {
    /**
     * 合并两个二叉树
     * 1: 思路
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * <p>
     * 前序遍历 1，同时前序遍历   2；分别处理left，right。遇到有一个为null就结束递归
     * 递归实现：
     * <p>
     * https://leetcode-cn.com/problems/merge-two-binary-trees/
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }
    public static TreeNode dfs(TreeNode t1, TreeNode t2) {
        // 遇到有一个为null就结束递归
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        // 如果两个都不为空.数值相加
        t1.val += t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);
        return t1;
    }

    /**
     * 合并两个二叉树
     * 1: 思路
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * <p>
     * 广度遍历：需要一个队列来保存二叉树层次信息.
     *  队列 1 2
     *  1 2 开始处理，1有左右，2也有左右，所以
     *  队列 3 1    2 3
     *  3 1 开始处理  （由于 3 1 中  1的左节点 空，所以r1不做任何操作。左节点到此结束）(同时 3的右节点为空，所以右节点也到此结束。所有3 1 结束)
     *  2 3 开始处理   直接把 tree2的左右都赋值过来。
     * https://leetcode-cn.com/problems/merge-two-binary-trees/
     */
    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        // 遇到有一个为null就结束递归
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        // 需要一个队列来存储
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);

        while(!queue.isEmpty()){
            TreeNode r1= queue.remove();
            TreeNode r2= queue.remove();
            r1.val += r2.val;
            //
            if(r1.left !=null && r2.left != null){
                queue.add(r1.left);
                queue.add(r2.left);
            } else {
                if(r1.left == null) {
                    r1.left = r2.left;
                }
            }
            // 对于右子树也是一样的
            if(r1.right!=null && r2.right!=null) {
                queue.add(r1.right);
                queue.add(r2.right);
            }
            else if(r1.right==null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }


    /**
     * 二叉树 的层级遍历， 广度优先遍历
     *    3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * 思路
     * 1：需要一个队列存放当前层级的数据
     * 2：遍历队列的所有点，得到他们的left和right放入新的队列
     * 3：直到队列没有数据
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * @param root
     * @return
     */
    public static  List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmpr = new ArrayList<>();
            // 进来的时候queue有多大，后面再添加也不怕了。
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode head = queue.remove();
                tmpr.add(head.val);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right !=null ){
                    queue.add(head.right);
                }
            }
            result.add(tmpr);
        }
        return result;
    }


}
