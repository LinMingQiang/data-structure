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
            if (A[i] < B[j]) { // 把较大的数放到a的尾部
                A[aLength--] = B[j--];
            } else {
                A[aLength--] = A[i--];
            }
        }
        while (j >= 0) A[aLength--] = B[j--]; // 因为最终结果是放A数组，所以如果B还没遍历完，就把B剩下的全部放A的头部去（因为A都放回尾部了）
    }

    /**
     *  遍历到i的时候，如果前面的数组的最大子数组和是负数的话，可以直接舍弃掉，取nums[i]就行了。
     *  sum就是这个“i之前最大子数组的和”，如果它大于0，则加上num就是“i+1之前最大子数组的和”；
     *  如果它小于0，则num本身就是“i+1之前最大子数组的和”。
     *  例如前面sum=5，下一个是 -6（即使不是-6，只要后面 n个数加起来 是-6 也行） ，加完之后是-1，
     *  那前面的序列不要了，从-6开始，因为不管后面是多少，都被-6影响。后面只有出现 6+ 才会回到正
     *  例如：
     *  后面是3，那结果还是  负数 < 5 （那5是最大序列）  ，
     *  后面是 6 >5 前面的5序列还是要扔掉，
     *  后面是 -1   负数 < 5 （那5是最大序列），
     *
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums){
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

