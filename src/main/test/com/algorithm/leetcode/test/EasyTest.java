package com.algorithm.leetcode.test;

import com.algorithm.leetcode.normal.JavaBeanManager.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static com.algorithm.leetcode.easy.EasySolution.*;
import static com.algorithm.leetcode.util.AlgorithmUtil.println;

public class EasyTest {

    /**
     * 一维数组的动态和
     * https://leetcode-cn.com/problems/running-sum-of-1d-array/
     */
    @Test
    public void testRunningSum() {
        int[] a = {1, 2, 3, 4};
        println(runningSum(a));
    }

    /**
     * 1431. 拥有最多糖果的孩子
     * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
     */
    @Test
    public void testkidsWithCandies() {
        int[] a = {1, 2, 3, 4};
        println(kidsWithCandies(a, 5));
    }

    /**
     * 面试题 10.01. 合并排序的数组
     * https://leetcode-cn.com/problems/sorted-merge-lcci/
     */
    @Test
    public void testmerge() {
        int[] a = {1, 2, 3, 4, 0, 0, 0, 0};
        int[] b = {2, 3, 4, 5};
        merge(a, 4, b, 4);
        println(a);
    }

    /**
     * 53 最大子序和
     * https://leetcode-cn.com/problems/maximum-subarray/
     */
    @Test
    public void testmaxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 112. 路径总和
     * https://leetcode-cn.com/problems/path-sum/
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     */
    @Test
    public void testhasPathSum() {
        TreeNode l4 = new TreeNode(4, new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null);
        TreeNode r8 = new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, null, new TreeNode(1, null, null)));
        TreeNode a5 = new TreeNode(5, l4, r8);
        System.out.println(hasPathSum(a5, 18));
    }

    @Test
    public void testshuffleArr(){
        int[] a = {2,5,1,3,4,7};
        println(shuffleArr(a, 3));
    }
}
