package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        head = second;
        ListNode temp = null;
        ListNode preFirst = null;
        while(first != null && (second = first.next) != null) {
            temp = second.next;
            second.next = first;
            if (preFirst != null) {
                preFirst.next = second;
            }
            preFirst = first;
            first.next = temp;
            first = first.next;
        }
        return head;
    }

}
