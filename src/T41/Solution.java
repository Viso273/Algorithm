package T41;
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
//示例 1：
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。
//
//示例 2：
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。
//
//示例 3：
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。
public class Solution {
    //对于长度为 n 的数组，缺失的第一个正数一定落在区间 [1, n+1] 内。
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将所有干扰项（负数、0）替换为 n+1（一个不可能在 [1,n] 范围内的数，相当于"无效值"）。
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            // 将索引 num-1 处的值标记为负数，表示"数字 num 已出现"
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
