package com.darkness463.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * https://leetcode-cn.com/problems/happy-number/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while (!nums.contains(n)) {
            nums.add(n);
            n = getSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum += Math.pow(i, 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }

}
