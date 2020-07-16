package com.algorithm.leetcode.test;

import static com.algorithm.leetcode.easy.EasySolution.*;

import static com.algorithm.leetcode.easy.EasyOfferSolution.*;

import org.junit.Test;
import static com.algorithm.leetcode.normal.NomalOfferSolution.*;
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
     *
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
     *
     * @return
     */
    @Test
    public void testreversePrint() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        println(reversePrint(a));
    }


    /**
     * 剑指 Offer 27. 二叉树的镜像
     * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     */
    @Test
    public void testmirrorTree() {
        TreeNode l4 = new TreeNode(4, new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null);
        TreeNode r8 = new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, null, new TreeNode(1, null, null)));
        TreeNode a5 = new TreeNode(5, l4, r8);
        println(mirrorTree(a5));
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     */
    @Test
    public void testspiralOrder() {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        println(spiralOrder(a));
    }


    /**
     * 剑指 Offer 24. 反转链表
     * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
     */
    @Test
    public void testreverseList() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        println(reverseList(a));
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     */
    @Test
    public void testdeleteNode() {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        println(deleteNode(a, 3));
    }

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     */
    @Test
    public void testmajorityElement() {
        int[] a = {1, 1, 1, 1, 2, 2, 2, 2, 1, 5};
        println(majorityElement(a));
    }

    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     */
    @Test
    public void testkthLargest() {
        TreeNode l4 = new TreeNode(4, null, null);
        TreeNode r8 = new TreeNode(8, null, new TreeNode(13, null, null));
        TreeNode a5 = new TreeNode(5, l4, r8);
        println(kthLargest(a5, 2));
    }

    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     */
    @Test
    public void testisStraight() {
        int[] a = {0,0,1,2,3};
        println(isStraight(a));
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
     */
    @Test
    public void testverifyPostorder(){
        int[] no = {1,6,3,2,5};
        println(verifyPostorder(no));
        int[] yes = {1,3,2,6,5};
        println(verifyPostorder(yes));

    }


    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     */
    @Test
    public void testpathSum(){
        TreeNode l4 = new TreeNode(4, null, null);
        TreeNode r8 = new TreeNode(8, null, new TreeNode(13, null, null));
        TreeNode a5 = new TreeNode(5, l4, r8);
        println( pathSum(a5, 9));
    }
}
