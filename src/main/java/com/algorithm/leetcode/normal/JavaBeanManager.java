package com.algorithm.leetcode.normal;

public class JavaBeanManager {
    /**
     * 二叉树
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 链表
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int x) {
            val = x;
        }
    }
}
