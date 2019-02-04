package com.darkness463.leetcode.string;

/**
 * 38. 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * https://leetcode-cn.com/problems/count-and-say/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String lastStr = "1";
        for (int i = 2; i <= n; i++) {
            char[] chars = lastStr.toCharArray();
            StringBuilder sb = new StringBuilder();
            char lastChar = chars[0];
            int cnt = 1;
            for (int j = 1; j < chars.length; j++) {
                if (lastChar == chars[j]) {
                    cnt++;
                } else {
                    sb.append(cnt).append(lastChar);
                    lastChar = chars[j];
                    cnt = 1;
                }
            }
            sb.append(cnt).append(lastChar);
            lastStr = sb.toString();
        }
        return lastStr;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(10));
    }

}
