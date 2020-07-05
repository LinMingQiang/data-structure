package com.algorithm.leetcode.test;
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


}
