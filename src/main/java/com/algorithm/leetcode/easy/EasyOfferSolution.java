package com.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.LinkedList;
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
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null; // 前一个节点
        ListNode cur = head; // 当前节点
        ListNode next = null; // 下一个节点
        while (cur != null) {
            next = cur.next; // 先保存下个节点
            cur.next = pre; // 当前节点的下个节点指向上一个节点
            pre = cur; // 上个节点指向当前节点
            cur = next;  // 当前节点指向下一个节点
        }
        return pre;
    }


    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
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
     *
     * @param nums 假设 第一个就是众数，如果不是众数，一定会被真正的众数替代
     * @return
     */
    public static int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num; // 如果数值等于0，说明众数在剩下的数里面。
            votes += num == x ? 1 : -1;
        }
        return x;
    }


    /**
     * 中序遍历，先右后左，找到第k就返回
     */
    public static int res, ks;

    public static int kthLargest(TreeNode root, int k) {
        ks = k;
        dfs(root);
        return res;
    }

    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right); // 一直向右找
        if (--ks == 0) {
            res = root.val;
            return;
        }
        dfs(root.left); // 最后向左找
    }


    /**
     * 重复排跳出。大小王跳过；结果的最大和最小的差距不超过5就可以
     *
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


    /**
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    /**
     * minPrice : i天之前的最小价格
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, res = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // 得到i天之前的最小价格
            res = Math.max(res, price - minPrice); // 同之前的结果比较，当前价格-之前最小价格
        }
        return res;
    }

    /**
     * 用两个栈实现队列的功能
     */
    public static class CQueue {
        LinkedList<Integer> a, b;

        public CQueue() {
            a = new LinkedList<Integer>();
            b = new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            a.addLast(value);
        }

        public int deleteHead() {
            if (!b.isEmpty()) { // b里面有元素
                return b.removeLast();
            } else if (a.isEmpty()) { // a里面没有元素
                return -1;
            } else { // a里面有元素，b里面没有元素
                while (!a.isEmpty()) { // 将a的元素放入b
                    b.addLast(a.removeLast());
                }
                return b.removeLast();
            }

        }
    }

    /**
     * 二分查找
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2; // 中间
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    /**
     * 判断B是不是A的子结构
     * 三部走： 是否A根节点开始，是否是A的左子树，是否是A的右子树
     * 递归 ： B遍历完返回成功。A遍历完或者值不等，放回失败。 否则就继续比较左，右 子树是否相等
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) &&
                ( compareTree(A, B) ||  // 判断两个是否相等
                        isSubStructure(A.left, B) ||  // 判断B是否为A的左子树
                        isSubStructure(A.right, B));
    }

    public static boolean compareTree(TreeNode A, TreeNode B) {
        if (B == null) return true; // B访问完了，A不管为不为null
        if (A == null || A.val != B.val) return false; // 值不相等也放回false
        return compareTree(A.left, B.left) && compareTree(A.right, B.right); // 继续比较其他节点
    }
}
