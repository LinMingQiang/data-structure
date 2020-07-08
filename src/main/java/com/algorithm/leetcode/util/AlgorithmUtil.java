package com.algorithm.leetcode.util;

import com.algorithm.leetcode.normal.JavaBeanManager;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.List;

public class AlgorithmUtil {
    public static void println(int[] d) {
        for (int i : d) {
            System.out.println(i);
        }
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
}
