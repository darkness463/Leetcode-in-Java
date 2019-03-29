package com.darkness463.leetcode.array;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * https://leetcode-cn.com/problems/missing-number/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum ^= i;
            sum ^= nums[i];
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        boolean[] flags = new boolean[nums.length + 1];
        for (int num : nums) {
            flags[num] = true;
        }
        int index = 0;
        for (boolean b : flags) {
            if (!b) {
                return index;
            }
            index++;
        }
        return -1;
    }

}
