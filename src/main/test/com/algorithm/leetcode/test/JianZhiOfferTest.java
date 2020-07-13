package com.algorithm.leetcode.test;

import static com.algorithm.leetcode.easy.EasySolution.*;

import static com.algorithm.leetcode.easy.EasyOfferSolution.*;

import org.junit.Test;

import static com.algorithm.leetcode.util.JavaBeanManager.*;

import static com.algorithm.leetcode.util.AlgorithmUtil.println;

public class JianZhiOfferTest {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     */
    @Test
    public void testfindRepeatNumber() {
        int[] a = {4, 2, 1, 1, 0};
        System.out.println(findRepeatNumber(a));
    }

    /**
     * 剑指 Offer 04. 二维数组中的查找
     * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
     */
    @Test
    public void testfindNumberIn2DArray() {
        int[][] a = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};
        System.out.println(findNumberIn2DArray(a, 11));
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * @author LMQ
     * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     */
    @Test
    public void testgetKthFromEnd() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        println(getKthFromEnd(a, 1));
    }
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     * @return
     */
    @Test
    public void testreversePrint(){
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        println(reversePrint(a));
    }


    /**
     * 剑指 Offer 27. 二叉树的镜像
     * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     */
    @Test
    public void testmirrorTree() {
        TreeNode l4 = new TreeNode(4, new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null);
        TreeNode r8 = new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, null, new TreeNode(1, null, null)));
        TreeNode a5 = new TreeNode(5, l4, r8);
        println(mirrorTree(a5));
    }

    /**
     *  剑指 Offer 29. 顺时针打印矩阵
     *  https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     */
    @Test
    public void testspiralOrder(){
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        println(spiralOrder(a));
    }
}
