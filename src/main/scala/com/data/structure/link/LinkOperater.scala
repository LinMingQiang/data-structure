package com.data.structure.link

object LinkOperater {
  /**
   * 链表操作
   *
   */
  def main(args: Array[String]): Unit = {
    val f = SingleNode(6, null)
    val e = SingleNode(5, f)
    val d = SingleNode(4, e)
    val c = SingleNode(3, d)
    val b = SingleNode(2, c)
    val head = SingleNode(1, b) //head

    //reverseLink(a).print()
    
    JosephosUnRecursion(head, 3)
    head.print()
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
   * 约瑟夫环问题 (非递归方法)
   * m:数到第几就kill
   */
  def JosephosUnRecursion(head: SingleNode, m: Int) {
    var pre: SingleNode = head
    var current: SingleNode = head.next
    var num = 1 //from 1
    while (current != null) {
      num+=1
      if (num == m) {//kill
        pre.next=current.next//delete current node
        num=0
      }else {
        pre=current
      }
      current=current.next
    }

  }
  /**
   * 约瑟夫环问题 (递归方法)
   * m:数到第几就kill
   * live:剩下多少人停止
   */
  def JosephosRecursion(head: SingleNode, m: Int, live: Int) {

  }
}
