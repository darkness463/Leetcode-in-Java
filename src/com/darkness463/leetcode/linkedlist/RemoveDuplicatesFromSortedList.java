package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode lastNode = head;
        while ((node = node.next) != null) {
            if (node.val == lastNode.val) {
                lastNode.next = node.next;
            } else {
                lastNode = node;
            }
        }
        return head;
    }

}
