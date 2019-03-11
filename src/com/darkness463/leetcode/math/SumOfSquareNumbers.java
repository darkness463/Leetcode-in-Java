package com.darkness463.leetcode.math;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        if (sqrt(c)) {
            return true;
        }

        for (int i = 1; i <= (c / 2) / i; i++) {
            int sub = c - i * i;
            if (sqrt(sub)) {
                return true;
            }
        }
        return false;
    }

    private boolean sqrt(int c) {
        if (c == 0 || c == 1) {
            return true;
        }

        int sqrt = (int) Math.sqrt(c);
        return sqrt * sqrt == c;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(3));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(2));
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(2147483646));
    }

}
