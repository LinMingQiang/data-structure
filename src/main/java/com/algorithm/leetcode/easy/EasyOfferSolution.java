package com.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static com.algorithm.leetcode.util.JavaBeanManager.*;

public class EasyOfferSolution {
    /**
     * 1: 定义两个节点，left ，right。同时移动，当两个节点的差距到达k之后同时移动。等right移动到结尾的时候输出left
     *
     * @param head
     * @param k
     * @return
     * @author lmq
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }


    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }


    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmpLeft = root.left; // 把左节点暂存
        root.left = mirrorTree(root.right); // 把左节点置换为右节点的数据，右节点进去也是先把左节点全部换成右节点数据
        root.right = mirrorTree(tmpLeft);
        return root;
    }

    /**
     * 当 left> = right 退出
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int left = 0; // 当前遍历的列(右边界，每遍历一遍 left+1 )
        int right = matrix[0].length - 1; // 当前遍历的列(右边界，每遍历一遍 right-1 )
        int top = 0; // 当前遍历到行（上边界, 每遍历一遍 top+1 ）
        int bottom = matrix.length - 1; //  当前遍历到行（下边界, 每遍历一遍 bottom - 1）
        int x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];

        while (true) {
            for (int i = left; i <= right; i++) res[x++] = matrix[top][i]; // 从左到右赋值， 行 = top
            if (++top > bottom) break;  // top > bottom 退出
            for (int i = top; i <= bottom; i++) res[x++] = matrix[i][right]; // 从上到下，列数-1
            if (left > --right) break;
            for (int i = right; i >= left; i--) res[x++] = matrix[bottom][i]; // 从左到右赋值， 行 = top
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) res[x++] = matrix[i][left]; // 从左到右赋值， 行 = top
            if (++left > right) break;

        }
        return res;
    }


    /**
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null; // 前一个节点
        ListNode cur = head; // 当前节点
        ListNode next = null; // 下一个节点
        while (cur != null) {
            next = cur.next ; // 先保存下个节点
            cur.next = pre; // 当前节点的下个节点指向上一个节点
            pre = cur; // 上个节点指向当前节点
            cur = next;  // 当前节点指向下一个节点
        }
        return pre;
    }


    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }

    /**
     * 摩尔投票法：
     * 票数和： 由于众数出现的次数超过数组长度的一半；若记 众数 的票数为 +1+1 ，非众数 的票数为 -1−1 ，则一定有所有数字的 票数和 > 0>0 。
     * 票数正负抵消： 设数组 nums 中的众数为 x ，数组长度为 nn 。若 nums 的前 aa 个数字的 票数和 = 0=0 ，则 数组后 (n-a)(n−a) 个数字的 票数和一定仍 >0>0 （即后 (n-a)(n−a) 个数字的 众数仍为 xx ）。
     * @param nums 假设 第一个就是众数，如果不是众数，一定会被真正的众数替代
     * @return
     */
    public static int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num; // 如果数值等于0，说明众数在剩下的数里面。
            votes += num == x ? 1 : -1;
        }
        return x;
    }


    /**
     *  中序遍历，先右后左，找到第k就返回
     */
    public static int res, ks;
    public static int kthLargest(TreeNode root, int k) {
        ks = k;
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right); // 一直向右找
        if(--ks == 0) { res = root.val; return; }
        dfs(root.left); // 最后向左找
    }


    /**
     * 重复排跳出。大小王跳过；结果的最大和最小的差距不超过5就可以
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
