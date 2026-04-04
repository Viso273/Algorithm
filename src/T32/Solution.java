package T32;

import java.util.Deque;
import java.util.LinkedList;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
//左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
//
//示例 1：
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//
//示例 2：
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
//
//示例 3：
//输入：s = ""
//输出：0
public class Solution {
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        // 栈底存放哨兵，代表左边界的前一个位置，用索引直接减去就能得到最长子串，因为索引从0开始，也相当于少1个距离
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果栈空，则说明没有有效括号子串，需要更新哨兵
                    stack.push(i);
                } else {
                    // 如果栈不为空，则说明存在更长的有效括号子串，需要更新
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
