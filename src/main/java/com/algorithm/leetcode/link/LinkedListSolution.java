package com.algorithm.leetcode.link;

import com.algorithm.leetcode.util.JavaBeanManager.ListNode;

/**
 * 链表相关
 */
public class LinkedListSolution {

    /**
     * 方法1： 1->2->3->4->5
     *        head -> 1->2->3->4 ;last = 1 ;tmp = 2
     *        head -> 1-> 3 ->4 ; last.next = tmp.next;
     *        head -> 2->1->3->4 ; tmp.next = head.next; head.next = tmp;
     *        head -> 2->1->4   ; tmp = last.next
     *
     *        head -> 3->2->1->4
     * return head.next
     * @param src
     * @return
     */
    public static ListNode reverseList(ListNode src) {
        ListNode head = new ListNode(0, src);
        ListNode tmp = src.next;
        ListNode last = src;
        while(tmp != null){
            last.next = tmp.next;
            tmp.next = head.next; head.next = tmp;
            tmp = last.next;
        }
        return head.next;
    }

    /**
     * 方法1： 1->2->3->4->5
     *       两个列表： cur 为剩下的， pre为已经逆转好了的
     *       cur = 1->2->3->4; pre = bull;
     *       tmp = cur.next;     保存下一个 2
     *       cur.next = pre ;    逆转当前  1->null
     *       pre = cur;          上一个为 当前  pre = 1;
     *       cur = tmp;          cur = 2->3->4->5; pre = 1->null
     *       条件 cur ! =null
     * return pre
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while(cur != null){
             tmp = cur.next;
            cur.next = pre ;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
