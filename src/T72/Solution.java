package T72;
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
//你可以对一个单词进行如下三种操作：
//插入一个字符
//删除一个字符
//替换一个字符
//
//示例 1：
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//示例 2：
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
public class Solution {
    // 动态规划解决
    // dp[i][j]表示的是将word1的前i个元素转为word2的前j个元素所使用的最少操作数
    // 初始化：边界值进行初始化，dp[0][j]和dp[i][0]
    // 递推公式：
    // dp[i][j]=Math.min(dp[i][j-1]+1,Math.min(dp[i-1][j]+1,left_down))
    // left_down需要分情况讨论，当word1[i]和word2[j]相同的时候，不需要进行操作，两者不同时只需要步数加一
    public int minDistance(String word1, String word2) {
        //异常处理
        int n = word1.length();
        int m = word2.length();
        if(n*m == 0) return Math.max(n,m);

        //动态数组
        int[][] dp = new int[n+1][m+1];

        //初始化
        for (int i=0;i<n+1;i++) dp[i][0] = i;
        for (int i=0;i<m+1;i++) dp[0][i] = i;

        //递推构造
        for(int i=1;i<n+1;i++){
            for (int j=1; j<m+1; j++) {
                int left = dp[i-1][j]+1;
                int down = dp[i][j-1]+1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)) left_down+=1;
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[n][m];
    }
}
