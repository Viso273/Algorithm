package T43;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
//它们的乘积也表示为字符串形式。
//注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
//
//示例 1:
//输入: num1 = "2", num2 = "3"
//输出: "6"
//
//示例 2:
//输入: num1 = "123", num2 = "456"
//输出: "56088"
public class Solution {
    public static String multiply(String num1, String num2) {
        // 特殊值处理
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 存储num1上每一位和num2相乘的结果
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m+n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        // 对相乘的结果进行加工，处理进位信息
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i-1] += ansArr[i]/10;
            ansArr[i] = ansArr[i]%10;
        }
        // 拼接结果,将数组转为字符串
        int startIndex = (ansArr[0] == 0 ? 1 : 0);
        StringBuilder sb = new StringBuilder();
        while (startIndex < n + m) {
            sb.append(ansArr[startIndex]);
            startIndex++;
        }
        return sb.toString();
    }
}
