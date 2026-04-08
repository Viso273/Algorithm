package T322;

import java.util.Arrays;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//计算并返回可以凑成总金额所需的 最少的硬币个数 。
//如果没有任何一种硬币组合能组成总金额，返回 -1 。
//你可以认为每种硬币的数量是无限的。
//
//示例 1：
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
//示例 2：
//输入：coins = [2], amount = 3
//输出：-1
//
//示例 3：
//输入：coins = [1], amount = 0
//输出：0
import java.util.Arrays;
import java.util.Map;

public class Solution {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        // 升序排列
        Arrays.sort(coins);
        // dp[i] 表示凑出金额 i 所需的最少硬币数
        // 初始化为 amount + 1（相当于无穷大，因为最多用 amount 个1元硬币）
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        // 遍历每个金额
        for(int i = 1; i <= amount; i++){
            //遍历各个硬币
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        // 如果仍为初始值，说明无法凑出
        return dp[amount]>amount ? -1 : dp[amount];
    }
}