package T165;
//给你两个 版本号字符串 version1 和 version2 ，请你比较它们。
//版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
//比较版本号时，请按 从左到右的顺序 依次比较它们的修订号.
//如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
//返回规则如下：
//
//如果 version1 < version2 返回 -1，
//如果 version1 > version2 返回 1，
//除此之外返回 0。
//
//示例 1：
//输入：version1 = "1.2", version2 = "1.10"
//输出：-1
//解释：
//version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
//
//示例 2：
//输入：version1 = "1.01", version2 = "1.001"
//输出：0
//解释：
//忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
//
//示例 3：
//输入：version1 = "1.0", version2 = "1.0.0.0"
//输出：0
//解释：
//version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
public class Solution {
    // 划分子串，按照.为分割线
    // 双指针遍历两个串
    // 设置两个变量temp1和temp2记录分割过程中两个子串各自的得到的结果
    // 比较这两个变量
    public static int compareVersion(String version1, String version2) {
        // 获取version1和version2的长度
        int n = version1.length();
        int m = version2.length();
        // 双指针遍历
        int i=0,j=0;
        // 遍历
        while(i<n || j<m){
            // 存放1的版本号
            int x = 0;
            // 找x的第一个分割结果
            for (; i < n && version1.charAt(i)!='.'; i++) {
                // 易错点：未将字符转为数字使用
                x = 10*x + version1.charAt(i)-'0';
            }
            // 跳过“ . ”
            i++;
            // 存放2的版本号
            int y = 0;
            // 找y的第一个分割结果
            for (; j < m && version2.charAt(j)!='.'; j++) {
                y = 10*y + version2.charAt(j)-'0';
            }
            // 跳过“ . ”
            j++;
            if(x!=y) return x>y ? 1:-1;
        }
        return 0;
    }
}
