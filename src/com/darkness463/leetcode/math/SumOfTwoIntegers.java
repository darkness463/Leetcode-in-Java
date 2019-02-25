package com.darkness463.leetcode.math;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(1, 2));
        System.out.println(new SumOfTwoIntegers().getSum(-2, 3));
    }

}
