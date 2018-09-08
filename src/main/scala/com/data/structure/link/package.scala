package com.data.structure

package object link {
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
}