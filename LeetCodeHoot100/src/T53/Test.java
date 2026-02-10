package T53;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//子数组是数组中的一个连续部分。
//
//示例 1：
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//示例 2：
//输入：nums = [1]
//输出：1
//
//示例 3：
//输入：nums = [5,4,-1,7,8]
//输出：23

public class Test {
    public static void main(String[] args) {
        //测试
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){
        //动态规划
        if(nums.length==0) return 0;
        //返回最大值
        int res = nums[0];
        //初始化
        int[] dp = new int[nums.length];
        //用第一个数初始化
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
