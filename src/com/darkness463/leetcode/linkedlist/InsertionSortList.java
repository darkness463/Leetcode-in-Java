package com.darkness463.leetcode.linkedlist;

import com.darkness463.leetcode.ListNode;


/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode position = getInsertPosition(head, next);
            if (position == null) {
                ListNode tmp = next.next;
                next.next = head;
                head = next;
                next = tmp;
            } else {
                ListNode tmp = position.next;
                ListNode tmpNext = next.next;
                position.next = next;
                next.next = tmp;
                next = tmpNext;
            }
        }
        return head;
    }

    private ListNode getInsertPosition(ListNode head, ListNode node) {
        if (head.val >= node.val) {
            return null;
        }

        ListNode index = head;
        while (index.next != null && index.val < node.val && index.next.val < node.val) {
            index = index.next;
        }
        return index;
    }

}
