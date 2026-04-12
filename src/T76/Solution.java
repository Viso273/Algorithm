package T76;
//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
//使得该子串包含 t 中的每一个字符（包括重复字符）。
//如果没有这样的子串，返回空字符串 ""。
//测试用例保证答案唯一。
//
//示例 1：
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
//
//示例 2：
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
//
//示例 3:
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
public class Solution {
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        int num = 0; // 滑动窗口字母种类，和t字母种类相异个数
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) num++;
            cnt[c]++;
        }

        int ansLocation = -1, ansLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); r++) {
            // 窗口最右字符滑入
            if (--cnt[s.charAt(r)] == 0) num--;

            // 当num等于0，表示滑动窗口成功覆盖t字符串
            while (num == 0) {
                int len = r - l + 1;
                if (len < ansLen) {
                    ansLocation = l;
                    ansLen = len;
                }

                // 窗口最左字符滑出
                if (++cnt[s.charAt(l)] == 1) num++;
                l++;
            }
        }
        return ansLocation == -1 ? "" : s.substring(ansLocation, ansLocation + ansLen);
    }
}
