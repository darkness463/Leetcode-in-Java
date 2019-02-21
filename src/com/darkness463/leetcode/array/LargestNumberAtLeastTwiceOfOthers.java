package com.darkness463.leetcode.array;

/**
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * <p>
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 * <p>
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 *
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int lastMax = 0;
        boolean got = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[lastMax]) {
                got = nums[i] >= 2 * nums[lastMax];
                lastMax = i;
            } else {
                got = got & nums[lastMax] >= 2 * nums[i];
            }
        }
        if (got) {
            return lastMax;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[]{0, 0, 3, 2}));
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[]{0, 2, 3, 0}));
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
