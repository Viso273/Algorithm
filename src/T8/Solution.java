package T8;

//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
//函数 myAtoi(string s) 的算法如下：
//空格：读入字符串并丢弃无用的前导空格（" "）
//符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。
//     如果两者都不存在，则假定结果为正。
//转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。
//     如果没有读取数字，则结果为0。
//舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，
//     使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，
//     大于 231 − 1 的整数应该被舍入为 231 − 1 。
//返回整数作为最终结果。
//
//示例 1：
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//带下划线线的字符是所读的内容，插入符号是当前读入位置。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//
//示例 2：
//输入：s = " -042"
//输出：-42
//解释：
//第 1 步："   -042"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -042"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -042"（读入 "042"，在结果中忽略前导零）
//               ^
//
//示例 3：
//输入：s = "1337c0d3"
//输出：1337
//解释：
//第 1 步："1337c0d3"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："1337c0d3"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："1337c0d3"（读入 "1337"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//
//示例 4：
//输入：s = "0-1"
//输出：0
//解释：
//第 1 步："0-1" (当前没有读入字符，因为没有前导空格)
//         ^
//第 2 步："0-1" (当前没有读入字符，因为这里不存在 '-' 或者 '+')
//         ^
//第 3 步："0-1" (读入 "0"；由于下一个字符不是一个数字，所以读入停止)
//          ^
//
//示例 5：
//输入：s = "words and 987"
//输出：0
//解释：
//读取在第一个非数字字符“w”处停止。
class Solution {
    public static int myAtoi(String s) {
        if (s == null) return 0;

        int n = s.length();
        int i = 0;

        // 1. 跳过前导空格（手动跳过避免 trim() 创建新字符串）
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= n) return 0;

        // 2. 处理符号位
        boolean isNegative = false;
        char firstChar = s.charAt(i);

        if (firstChar == '+') {
            i++;
        } else if (firstChar == '-') {
            isNegative = true;
            i++;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        }

        // 3. 转换数字（统一用负数存储，避免 Integer.MIN_VALUE 绝对值溢出问题）
        int result = 0;
        // 负数边界：如果 isNegative 为 true，下限是 MIN_VALUE；否则是 -MAX_VALUE
        int limit = isNegative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. 溢出检查
            // 下一步要执行：result = result * 10 - digit
            // 如果 result < (limit + digit) / 10，则 result * 10 - digit < limit（溢出）
            if (result < (limit + digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 - digit;
            i++;
        }

        return isNegative ? result : -result;
    }
}

