package com.darkness463.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 *
 *
 * 提示：
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 * https://leetcode-cn.com/problems/buddy-strings/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        // 两个字符串相同时，有重复的字母则返回true。
        if (A.equals(B)) {
            Set<Character> chars = new HashSet<>();
            for (char c : A.toCharArray()) {
                if (chars.contains(c)) {
                    return true;
                }
                chars.add(c);
            }
            return false;
        }

        int length = A.length();
        int head = 0, tail = length - 1;
        while (head < length && A.charAt(head) == B.charAt(head)) {
            head++;
        }
        while (tail >= head && A.charAt(tail) == B.charAt(tail)) {
            tail--;
        }

        // 只有一个字母不同，false。
        if (head == tail) {
            return false;
        }

        if (A.charAt(head) == B.charAt(tail)
                && A.charAt(tail) == B.charAt(head)) {
            if (tail - head == 1) {
                return true;
            } else {
                // 判断是否还有其他不同的字母
                return A.substring(head + 1, tail).equals(B.substring(head + 1, tail));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("ab", "ba"));
        System.out.println(new BuddyStrings().buddyStrings("ab", "ab"));
        System.out.println(new BuddyStrings().buddyStrings("aa", "aa"));
        System.out.println(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(new BuddyStrings().buddyStrings("", "aa"));
    }

}
