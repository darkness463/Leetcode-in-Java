package com.darkness463.leetcode.math;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * https://leetcode-cn.com/problems/sqrtx/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SqrtX {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int min = 0, max = x;
        while (min + 1 < max) {
            int mid = (min + max) / 2;
            if (mid > x / mid) {
                max = mid;
            } else if (mid < x / mid) {
                min = mid;
            } else {
                return mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(4));
        System.out.println(new SqrtX().mySqrt(8));
        System.out.println(new SqrtX().mySqrt(2147395599));
    }

}
