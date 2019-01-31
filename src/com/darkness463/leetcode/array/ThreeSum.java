package com.darkness463.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * https://leetcode-cn.com/problems/3sum/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = i + 1, last = nums.length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[first]);
                    item.add(nums[last]);
                    result.add(item);
                    first++;
                    last--;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                    while (last > first && nums[last] == nums[last + 1]) {
                        last--;
                    }
                } else if (sum > 0) {
                    last--;
                } else {
                    first++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

}
