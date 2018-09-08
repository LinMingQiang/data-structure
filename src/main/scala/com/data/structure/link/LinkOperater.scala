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
    val a = SingleNode(1, b) //head

    
    reverseLink(a).print()
  }
  /**
   * 反转单链表
   */
  def reverseLink(tmp: SingleNode)= {
    var head: SingleNode=tmp
    var nextHead: SingleNode = null
    var pre: SingleNode = null
    while (head != null) {
      
      //以下三步为反转操作。就是next和pre的互换。把当前head的next变成上一个pre。（注意要先把head.next拿出来）
    	nextHead = head.next //先把下一个记下来
      head.next=pre//将上一个 赋值给当前node的next。
      pre = head //记录下 ： 上一个
            
      head=nextHead  //开始计算下一个
    }
   pre
  }
}
case class SingleNode(
    var value: Int,
    var next: SingleNode) {
  def print() {
    println(value)
    if (next != null)
      next.print
  }
}
case class DoubleNode(
    var velue: Int,
    var per: DoubleNode,
    var next: DoubleNode) {
  def print() {
    if (next != null)
      next.print
    println(velue)
  }
}