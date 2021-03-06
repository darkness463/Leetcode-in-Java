package com.darkness463.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ImplementStackUsingQueues {

    class MyStack {

        Queue<Integer> popQueue = new ArrayDeque<>();
        Queue<Integer> pushQueue = new ArrayDeque<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            pushQueue.add(x);
            while (!popQueue.isEmpty()) {
                pushQueue.offer(popQueue.poll());
            }

            while (!pushQueue.isEmpty()) {
                popQueue.offer(pushQueue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return popQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return popQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return popQueue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
