package com.algorithm.leetcode.easy;

import static com.algorithm.leetcode.util.AlgorithmUtil.*;

import org.junit.Test;

public class EasySolution {
    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

