package com.algorithm.leetcode.test.link;

import com.algorithm.leetcode.link.LinkedListSolution;
import com.algorithm.leetcode.normal.NomalSolution;
import com.algorithm.leetcode.tree.TreeSolution;
import com.algorithm.leetcode.util.JavaBeanManager.*;
import org.junit.Test;

import static com.algorithm.leetcode.easy.EasyOfferSolution.reverseList;
import static com.algorithm.leetcode.util.AlgorithmUtil.println;

public class LinkedListTest {
    @Test
    public void testreverseList() {
        ListNode a = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        null))));
        println(LinkedListSolution.reverseList2(a));
    }


    @Test
    public void testlevelOrder(){
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        TreeNode root = NomalSolution.buildTree(a, b);
        println(TreeSolution.levelOrder(root));
    }
}
