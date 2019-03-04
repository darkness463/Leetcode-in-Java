package com.darkness463.leetcode.string;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * https://leetcode-cn.com/problems/add-strings/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }

        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        boolean up = false;
        StringBuilder sb = new StringBuilder();
        while (l1 >=0 || l2 >= 0) {
            int sum = 0;
            if (l1 >= 0 && l2 >= 0) {
                char c1 = num1.charAt(l1);
                char c2 = num2.charAt(l2);
                sum = (c1 - '0') + (c2 - '0');
            } else if (l1 >= 0) {
                char c1 = num1.charAt(l1);
                sum = c1 - '0';
            } else {
                char c2 = num2.charAt(l2);
                sum = c2 - '0';
            }

            if (up) {
                sum += 1;
                up = false;
            }

            if (sum >= 10) {
                sb.append((char) (sum % 10 + '0'));
                up = true;
            } else {
                sb.append((char) (sum+ '0'));
            }

            l1--;
            l2--;
        }
        if (up) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

}
