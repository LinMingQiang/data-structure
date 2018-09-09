package com.data.structure.link

object LinkOperater {
  /**
   * 链表操作
   *
   */
  def main(args: Array[String]): Unit = {
    val f = SingleNode(12, null)
    val e = SingleNode(10, f)
    val d = SingleNode(8, e)
    val c = SingleNode(6, d)
    val b = SingleNode(4, c)
    val head = SingleNode(2, b) //head

    val f2 = SingleNode(11, null)
    val e2 = SingleNode(9, f2)
    val d2 = SingleNode(7, e2)
    val c2 = SingleNode(5, d2)
    val b2 = SingleNode(3, c2)
    val head2 = SingleNode(1, b2) //head2

    mergeOrderLink(head2, head).print
    //reverseLink(a).print()

    //JosephosUnRecursion(head, 3)
    //head.print()

  }
  /**
   * 反转单链表
   */
  def reverseLink(tmp: SingleNode) = {
    var head: SingleNode = tmp
    var nextHead: SingleNode = null
    var pre: SingleNode = null
    while (head != null) {

      //以下三步为反转操作。就是next和pre的互换。把当前head的next变成上一个pre。（注意要先把head.next拿出来）
      nextHead = head.next //先把下一个记下来
      head.next = pre //将上一个 赋值给当前node的next。
      pre = head //记录下 ： 上一个

      head = nextHead //开始计算下一个
    }
    pre
  }
  /**
   * 1->3->5->7..
   * 2->4->6->8..
   * 合并有序的两个链表，使其依旧有序
   * 这边是以link1(因为link1是头结点)为主，将link2的node插入link1里面
   */
  def mergeOrderLink(link1: SingleNode, link2: SingleNode) = {
    //最终主体的最后一个node
    var mainLinkLastNode: SingleNode = SingleNode(0,null)//这里无所谓随便定义都可以不影响
    val head = mainLinkLastNode
    var l1 = link1
    var l2 = link2 
    var next: SingleNode = null
    while (l1 != null && l2 != null) {
      if (l1.value <= l2.value) {
        mainLinkLastNode.next = l1 //第一步的时候head.next也变了
        l1 = l1.next 
      } else {
        mainLinkLastNode.next = l2
        l2 = l2.next
      }
      mainLinkLastNode=mainLinkLastNode.next
    }
    mainLinkLastNode.next = if (l1 == null) l2 else l1
    head.next //head是(0,Node(1))所以要next
  }
  /**
   * 约瑟夫环问题 (非递归方法)
   * m:数到第几就kill
   */
  def JosephosUnRecursion(head: SingleNode, m: Int) {
    var pre: SingleNode = head
    var current: SingleNode = head.next
    var num = 1 //from 1
    while (current != null) {
      num += 1
      if (num == m) { //kill
        pre.next = current.next //delete current node
        num = 0
      } else {
        pre = current
      }
      current = current.next
    }

  }
  /**
   * 约瑟夫环问题 (递归方法)
   * m:数到第几就kill
   * live:剩下多少人停止
   * 递归的原理要推敲一下
   * 如 0,1,2,3,4,5,6,7,8,9
   * (0+3-1)%1
   * 3,4,5,6,7,8,9,0,1
   * (2+3)%10=5
   * 6,7,8,9,0,1,3,4
   * (5+3)%9=0
   * 一次出环的是 2 5 8 1 4 9
   *
   */
  def JosephosRecursion(sum: Int, m: Int, liveNum: Int): Int = {
    if (liveNum == 1) {
      (sum + m - 1) % sum
    } else
      (JosephosRecursion(sum - 1, m, liveNum - 1) + m) % sum
  }

}
