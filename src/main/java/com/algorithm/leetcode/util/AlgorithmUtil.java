package com.algorithm.leetcode.util;

import java.util.List;

public class AlgorithmUtil {
    public static void println(int[] d) {
        StringBuilder s = new StringBuilder("[");
        for (int i : d) {
            s.append(i);
            s.append(',');
        }
        s.setCharAt(s.length() - 1, ']');
        System.out.println(s);
    }

    public static void println(String[] d) {
        for (String i : d) {
            System.out.println(i);
        }
    }

    public static void println(List<Boolean> d) {
        for (Boolean i : d) {
            System.out.println(i);
        }
    }


    public static void printlnTreeLeft(JavaBeanManager.TreeNode head) {
        if (head == null) return;
        System.out.println(head.val);
        printlnTreeLeft(head.left);
        printlnTreeLeft(head.right);
    }

    public static void printlnTreeMid(JavaBeanManager.TreeNode head) {
        if (head == null) return;
        printlnTreeMid(head.left);
        System.out.println(head.val);
        printlnTreeMid(head.right);
    }

    public static void println(JavaBeanManager.ListNode n) {
        StringBuilder a = new StringBuilder("[");
        while (n != null) {
            a.append(n.val + ",");
            n = n.next;
        }
        a.setCharAt(a.length() - 1, ']');
        System.out.println(a.toString());
    }
}
