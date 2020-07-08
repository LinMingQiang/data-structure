package com.algorithm.leetcode.normal;

import java.util.HashMap;

import com.algorithm.leetcode.normal.JavaBeanManager.*;

public class NomalSolution {
    /**
     * 前序遍历特点： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序，以题目示例为例：[ 3 | 9 | 20 15 7 ]
     * 中序遍历特点： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序，以题目示例为例：[ 9 | 3 | 15 20 7 ]
     * 先找到前序中的根节点，然后用跟节点去找中序的，再得到左子树，再利用左子树在前序中找到跟节点。依次
     * 参数： 前序遍历中根节点的索引pre_root、中序遍历左边界in_left、中序遍历右边界in_right
     */
    public static HashMap<Integer, Integer> dic = new HashMap();
    public static int[] po;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return buildTreeRecur(0, 0, inorder.length - 1);
    }
    public static JavaBeanManager.TreeNode buildTreeRecur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(po[pre_root]); // 前序中的根节点
        // 根节点的值来找到。根据这个位置得到中序的 左子树 和右子树
        int i = dic.get(po[pre_root]); // 根节点在中序中的位置
        // pre_root + 1 为前序的 跟节点。  in_left 为 中序的左子树。 i -1 为中序的 左子树的最后一个。直到 in_left > in_right (等于为跟节点) 代表遍历结束
        root.left = buildTreeRecur(pre_root + 1, in_left, i - 1);
        // pre_root + (i - in_left) + 1 ： 根节点+左子树+1
        // i + 1 ： 中序 右子树的 左边界 ；  in_right ： 中序 右子树的 右边界
        root.right = buildTreeRecur(pre_root + (i - in_left) + 1, i + 1, in_right);
        return root;
    }

    //
}
