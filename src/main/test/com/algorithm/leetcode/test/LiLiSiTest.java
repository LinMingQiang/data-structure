package com.algorithm.leetcode.test;
import com.algorithm.leetcode.offer.LiLiSiOffer;
import org.junit.Test;

public class LiLiSiTest {
    @Test
    public void testMyStack(){
        LiLiSiOffer.MyStack m = new  LiLiSiOffer.MyStack();
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());

    }
}
