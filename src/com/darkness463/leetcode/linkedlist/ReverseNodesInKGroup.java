package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        int num = 0;
        ListNode last = head;
        while (num < k && last != null) {
            num++;
            last = last.next;
        }

        if (num == k) {
            ListNode pre = null, cur = head, next = null;
            while (cur != last) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if (next != null) {
                last.next = reverseKGroup(next, k);
            }
            return last;
        } else {
            return head;
        }
    }

}
