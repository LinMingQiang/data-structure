package com.algorithm.leetcode.normal;


import com.algorithm.leetcode.util.JavaBeanManager.*;

import java.util.LinkedList;
import java.util.List;

public class NomalOfferSolution {
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int start, int end) {

        if (start >= end) return true;
        int headVal = postorder[end];
        int m = start; // 中间比根节点大的那个数的位置
        while (postorder[m] < headVal) ++m;
        int midIndex = m; // 暂存中间结果；
        while (postorder[m] > headVal) ++m; // 右边应该全部大于headVal 应该遍历到最后
        return m == end && recur(postorder, start, midIndex - 1) && recur(postorder, midIndex, end - 1);

    }


    public static LinkedList<List<Integer>> res = new LinkedList<>();
    public static LinkedList<Integer> path = new LinkedList<>(); // 记录路径
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    public static void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast(); // 当前节点的左右都访问完还是不满足就把当前删除
    }
}
