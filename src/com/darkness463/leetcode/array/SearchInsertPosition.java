package com.darkness463.leetcode.array;

/**
 * 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = 0, max = nums.length;
        while (min <= max && min < nums.length && max >= 0) {
            int mid = (min + max) / 2;
            if (nums[mid] < target) {
                min = mid + 1;
            } else if (nums[mid] > target) {
                max = mid - 1;
            } else {
                return mid;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3,5,6}, 0));
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[] {1,3}, 1));
    }

}
