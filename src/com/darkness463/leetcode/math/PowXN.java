package com.darkness463.leetcode.math;

/**
 * 50
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * https://leetcode-cn.com/problems/powx-n/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }

        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (n == -1) {
            return 1 / x;
        }

        double pow = myPow(x, n / 2);
        if (n % 2 == 0) {
            return pow * pow;
        } else {
            if (n > 0) {
                return x * pow * pow;
            } else {
                return (1.0 / x) * pow * pow;
            }
        }
    }

    /**
     * 这种方式在n过大时，会StackOverFlow
     */
    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n > 1) {
            return x * myPow(x, n - 1);
        } else if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (n == -1) {
            return 1 / x;
        } else {
            return (1 / x) * myPow(x, n + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowXN().myPow(2.00000, 10));
        System.out.println(new PowXN().myPow(2.10000, 3));
        System.out.println(new PowXN().myPow(2.00000, -2));
    }

}
