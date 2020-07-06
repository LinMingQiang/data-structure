package com.data.structure.dp

object MaxSubsequenceSum_53 {
  // 53 最大子序和
  /**
    * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    *
    * 示例:
    *
    * 输入: [-2,1,-3,4,-1,2,1,-5,4],
    * 输出: 6
    * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    *
    * 来源：力扣（LeetCode）
    * 链接：https://leetcode-cn.com/problems/maximum-subarray
    * 遍历到i的时候，如果前面的数组的最大子数组和是负数的话，可以直接舍弃掉，取nums[i]就行了。
    *  sum就是这个“i之前最大子数组的和”，如果它大于0，则加上num就是“i+1之前最大子数组的和”；
    *  如果它小于0，则num本身就是“i+1之前最大子数组的和”。
    *  例如前面sum=5，下一个是 -6（即使不是-6，只要后面 n个数加起来 是-6 也行） ，加完之后是-1，
   *  那前面的序列不要了，从-6开始，因为不管后面是多少，都被-6影响。后面只有出现 6+ 才会回到正
   *  例如：
   *  后面是3，那结果还是  负数 < 5 （那5是最大序列）  ，
   *  后面是 6 >5 前面的5序列还是要扔掉，
   *  后面是 -1   负数 < 5 （那5是最大序列），
   *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val nums = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    var ans = nums(0);
    var sum = 0;
    nums.foreach { num =>
      if (sum > 0) {
        sum += num;
      } else {
        sum = num;
      }
      ans = Math.max(ans, sum);
    }
    println(ans)
  }
}
