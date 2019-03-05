package com.darkness463.leetcode.string;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right
                    && (chars[left] < 'a' || chars[left] > 'z')
                    && (chars[left] < '0' || chars[left] > '9')) {
                left++;
            }
            while (right > left
                    && (chars[right] < 'a' || chars[right] > 'z')
                    && (chars[right] < '0' || chars[right] > '9')) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            if (chars[left] != chars[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

}
