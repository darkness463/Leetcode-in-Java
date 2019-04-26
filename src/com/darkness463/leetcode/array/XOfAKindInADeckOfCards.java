package com.darkness463.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * @author <a href="mailto:darkness463@gmail.com">Darkness463</a>
 */
public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            Integer cnt = map.getOrDefault(num, 0);
            map.put(num, ++cnt);
        }
        int num = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (num == -1) {
                num = entry.getValue();
                if (num < 2) {
                    return false;
                }
            } else {
                int commonDivisor = getCommonDivisor(num, entry.getValue());
                if (commonDivisor < 2) {
                    return false;
                }
                num = commonDivisor;
            }
        }
        return true;
    }

    private int getCommonDivisor(int num1, int num2) {
        return num1 == 0 ? num2 : getCommonDivisor(num2 % num1, num1);
    }

}
