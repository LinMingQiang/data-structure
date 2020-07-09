package com.algorithm.leetcode.test;

import static com.algorithm.leetcode.easy.EasySolution.*;
import org.junit.Test;

import static com.algorithm.leetcode.util.AlgorithmUtil.println;

public class JianZhiOfferTest {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     */
    @Test
    public void testfindRepeatNumber() {
        int[] a = {4,2,1,1,0};
        System.out.println(findRepeatNumber(a));
    }

    /**
     * 剑指 Offer 04. 二维数组中的查找
     * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
     */
    @Test
    public void testfindNumberIn2DArray(){
        int[][] a = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
        System.out.println(findNumberIn2DArray(a, 11));
    }
}
