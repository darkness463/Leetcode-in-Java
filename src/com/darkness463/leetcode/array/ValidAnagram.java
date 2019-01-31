package com.darkness463.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母
 *
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer cnt = map.get(c);
            cnt = cnt == null ? 1 : ++cnt;
            map.put(c, cnt);
        }

        for (char c : t.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == null || cnt <= 0) {
                return false;
            } else {
                cnt--;
                if (cnt == 0) {
                    map.remove(c);
                } else {
                    map.put(c, cnt);
                }
            }
        }
        return map.size() == 0;
    }

}
