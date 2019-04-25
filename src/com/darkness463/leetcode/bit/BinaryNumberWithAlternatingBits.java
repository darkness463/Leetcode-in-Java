package com.darkness463.leetcode.bit;

/**
 * 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 *
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 *
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 *
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 *
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        boolean flag = (n & 1) == 1;
        n = n >> 1;
        while (n > 0) {
            boolean f = (n & 1) == 1;
            if ((f && flag) || (!f && !flag)) {
                return false;
            }
            flag = f;
            n = n >> 1;
        }
        return true;
    }

}
