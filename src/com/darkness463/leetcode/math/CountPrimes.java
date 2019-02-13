package com.darkness463.leetcode.math;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * https://leetcode-cn.com/problems/count-primes/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class CountPrimes {

    /**
     * Solution1, faster.
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 0;
        boolean[] flags = new boolean[n];
        for (int i = 2; i< n; i++) {
            if (!flags[i]) {
                count++;
                for (long j = (long)(i) * i; j < n; j += i) {
                    flags[(int) j] = true;
                }
            }
        }
        return count;
    }

    /**
     * Solution2, slower.
     */
    public int countPrimes2(int n) {
        Set<Integer> primes = new LinkedHashSet<>();
        for (int i = 2; i < n; i++) {
            if (isPrimes(primes, i)) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    public boolean isPrimes(Set<Integer> primes, int n) {
        int max = (int) Math.sqrt(n);
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return false;
            }
            if (prime > max) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
        System.out.println(new CountPrimes().countPrimes(499979));
    }

}
