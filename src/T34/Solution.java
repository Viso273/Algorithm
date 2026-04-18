package T34;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
//请你找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回 [-1, -1]。
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
//示例 2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
//示例 3：
//输入：nums = [], target = 0
//输出：[-1,-1]
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int startIndex = lowerBound(nums,target);

        //nums中没有target
        if(startIndex==nums.length || nums[startIndex]!=target){
            return new int[]{-1,-1};
        }
        //如果startIndex存在，则endIndex必定存在
        int endIndex = lowerBound(nums,target+1)-1;
        return new int[]{startIndex,endIndex};
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的下标 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]
    private static   int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid]>=target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

