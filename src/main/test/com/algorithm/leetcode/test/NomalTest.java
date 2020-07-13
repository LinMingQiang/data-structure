package com.algorithm.leetcode.test;

import com.algorithm.leetcode.util.JavaBeanManager;
import com.algorithm.leetcode.normal.NomalSolution;
import static com.algorithm.leetcode.normal.NomalSolution.*;
import static com.algorithm.leetcode.normal.NomalSolution.maxAreaOfIsland;

import com.algorithm.leetcode.util.AlgorithmUtil;
import org.junit.Test;

public class NomalTest {
    /**
     * 重建二叉树：给你前序和中序遍历的数组，重建一个二叉树
     * 递归
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     */
    public void testbuildTree() {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        JavaBeanManager.TreeNode root = NomalSolution.buildTree(a, b);
        AlgorithmUtil.printlnTreeLeft(root);
        AlgorithmUtil.printlnTreeMid(root);
    }

    /**
     * 695. 岛屿的最大面积
     * 深度优先搜索
     * https://leetcode-cn.com/problems/max-area-of-island/
     */
    @Test
    public void testmaxAreaOfIsland() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
