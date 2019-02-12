package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode lastNode = head;
        ListNode lastDifferentNode = null;
        while (node != null) {
            if (node.val == lastNode.val) {
                while (node != null && node.val == lastNode.val) {
                    node = node.next;
                }

                if (lastNode.val == head.val) {
                    head = node;
                } else {
                    lastDifferentNode.next = node;
                    lastNode = node;
                    if (node != null) {
                        node = node.next;
                    }
                }
            } else {
                lastDifferentNode = lastNode;
                lastNode = node;
                node = node.next;
            }
        }
        return head;
    }

}
