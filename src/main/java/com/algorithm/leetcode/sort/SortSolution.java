package com.algorithm.leetcode.sort;

public class SortSolution {



    // 冒泡： 相邻比较，较大的换到后面，这样较大的就每次慢慢沉淀到地下
    // 选择： 每次选择剩下队列里面最小的，放在数组前面，依次
    // 归并，堆，快速
    // https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
    public static int[] tmp;

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    /**
     * 归并排序
     * 需要一个临时数组，来存放两个合并后的有序结果，然后再把数组数据 放回原数组.
     * 三步骤： 1：判断递归结束点， left >= right
     *         2：递归左边，递归右边 (l, mid) (mid+1, r)
     *         3：合并两边数组到临时数组（l->mid有序，mid+1->r有序，合并 l->r有序），然后再写回原数组。
     * @param nums 原数组，最终结果
     * @param l    左边界 0       (0) (mid)
     * @param r    右边界 length - 1 (mid) (length - 1)
     */
    public static void mergeSort(int[] nums, int l, int r) {
        // 结束递归
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;   // 找到中间位置
        mergeSort(nums, l, mid); // 递归左边
        mergeSort(nums, mid + 1, r); // 递归右边
        // 当递归完后，前后都l-mid 是有序的， mid+1 - r 是有序的，需要两边合并，结果 l-r为有序的
        int i = l;
        int j = mid + 1;
        int tmpindex = 0; // 临时数组的下标
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[tmpindex++] = nums[i++];
            } else {
                tmp[tmpindex++] = nums[j++];
            }
        }
        // 把剩下的遍历完
        while (i <= mid) {
            tmp[tmpindex++] = nums[i++];
        }
        while (j <= r) {
            tmp[tmpindex++] = nums[j++];
        }

        // 把合并好的数组数据写回nums
        int curLen = r - l + 1; // 合并后的长度
        for (int k = 0; k < curLen; k++) {
            nums[l + k] = tmp[k];
        }
    }


    /**
     * 快排
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums){
        quickSort(nums, 0, nums.length -1);
        return nums;
    }
    /**
     * 思路：
     * 选第一个为几点
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums, int l, int r){



    }









}
