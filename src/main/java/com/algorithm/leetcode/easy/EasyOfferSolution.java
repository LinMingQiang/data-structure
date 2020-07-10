package com.algorithm.leetcode.easy;

import static com.algorithm.leetcode.normal.JavaBeanManager.*;

public class EasyOfferSolution {
    /**
     * 1: 定义两个节点，left ，right。同时移动，当两个节点的差距到达k之后同时移动。等right移动到结尾的时候输出left
     * @author lmq
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
