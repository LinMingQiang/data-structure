package com.algorithm.leetcode.easy;

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


}
