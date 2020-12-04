package com.algorithm.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

public class LiLiSiOffer {
    /**
     * 用队列实现 栈
     * 入栈 1，2，3，4， 出栈， 4，3，2，1
     * 队列 offer ：数据放最后
     * 队列 peek : 获取第一个数据
     * 队列 poll ： 获取第一个并删除
     */
  public static class MyStack{
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        // 进栈
        public void push(int x) {
            if(!queue.isEmpty()) {
                // 不为空，先将数据放队列最后
                queue.offer(x);
                for (int i = 0; i < queue.size() - 1; i++) {
                    // 将元素一个一个拿出来放最后一个,直到最新的元素在第一个
                    queue.offer(queue.poll());
                }
            } else {
                queue.offer(x);
            }
        }
        // 出栈，并删除第一个元素
        public int pop() {
            return queue.poll();
        }
       // 返回第一个元素
        public int top() {
            return queue.peek();

        }
        // 判断是否为空
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
