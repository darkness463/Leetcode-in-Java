package com.darkness463.leetcode.math;

/**
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int mod = n % 26;
            n = n / 26;
            sb.append((char) (mod + 'A'));
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }

}
