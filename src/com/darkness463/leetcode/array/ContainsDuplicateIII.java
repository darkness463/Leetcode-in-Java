package com.darkness463.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 220. 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k <= 0 || t < 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (t == 0) {
                if(set.contains(num)) {
                    return true;
                }
            } else {
                for (Integer n : set) {
                    if (Math.abs(((long) n) - num) <= t){
                        return true;
                    }
                }
            }
            if (set.size() == k) {
                set.remove(nums[i - k]);
            }
            set.add(num);
        }
        return false;
    }

}
