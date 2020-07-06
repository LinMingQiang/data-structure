package com.algorithm.leetcode.easy;
import java.util.ArrayList;
import java.util.List;

public class EasySolution {

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;
    }

    /**
     * 利用A的数组后半部分，把较大者放到A的数组尾部，尾部从大到小排。
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int aLength = m + n - 1,
                i = m - 1,
                j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[aLength--] = B[j--];
            } else {
                A[aLength--] = A[i--];
            }
        }
        while (j >= 0) A[aLength--] = B[j--]; // 因为最终结果是放A数组，所以如果B还没遍历完，就把B剩下的全部放A的头部去（因为A都放回尾部了）
    }
}

