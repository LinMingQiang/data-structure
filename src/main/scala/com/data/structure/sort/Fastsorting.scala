package com.data.structure.sort

import scala.collection.mutable.ArrayBuffer

object Fastsorting {
  def main(args: Array[String]): Unit = {
    val a = Array(9,8,7,6,5,4,3,2,1,0)
    fastSorting(a, 0, a.size - 1)
    a.foreach(println)

  }

  /**
   * 快速排序
   */
  def fastSorting(arr: Array[Int], i: Int, j: Int) {
	  if(i>j) return; 
    var left = i
    var right = j
    var sentry = arr(i) //以左边第一个作为哨兵
    while (left < right) { //直到相遇
      while (right > left && arr(right) >= sentry)  //一直遇到比自己小的。 退出循环
        right -= 1
      while (left < right && arr(left) <= sentry)  //一直遇到比自己大的。 退出循环
        left += 1
       //记下比哨兵大的位置
      if (left < right) { //交换
        val tmp = arr(left)
        arr(left) = arr(right);
        arr(right) = tmp;
      }
    }
    //相遇退出。把哨兵的值置换到left=right的位置
    arr(i)=arr(left)//arr(i)就是哨兵
    arr(left)=sentry
    fastSorting(arr, i, left-1)//左边排序
    fastSorting(arr, right+1, j)//右边排序
  }
}