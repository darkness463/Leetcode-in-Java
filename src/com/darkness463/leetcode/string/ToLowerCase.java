package com.darkness463.leetcode.string;

/**
 * 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 *
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        int sub = 'a' - 'A';
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + sub);
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("Hello"));
        System.out.println(new ToLowerCase().toLowerCase("here"));
        System.out.println(new ToLowerCase().toLowerCase("LOVELY"));
    }

}
