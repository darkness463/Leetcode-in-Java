package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;

/**
 * 一：
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * https://leetcode-cn.com/problems/linked-list-cycle
 *
 *
 * 二：
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            ListNode next = fast.next;
            if (next == null) {
                return false;
            }

            fast = next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            ListNode next = fast.next;
            if (next == null) {
                return null;
            }

            fast = next.next;
            slow = slow.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode newNode = head;
            while (newNode != slow) {
                newNode = newNode.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }
    }

}
