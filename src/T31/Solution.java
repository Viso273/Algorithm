package T31;
//整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
//例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
//整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
//更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
//如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
//类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
//而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
//给你一个整数数组 nums ，找出 nums 的下一个排列。
//必须 原地 修改，只允许使用额外常数空间。
//
//示例 1：
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//示例 2：
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//示例 3：
//输入：nums = [1,1,5]
//输出：[1,5,1]
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 步骤 1: 从后往前找第一个升序对 (i, i+1)
        // 即找到第一个满足 nums[i] < nums[i+1] 的位置 i
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 步骤 2: 如果找到了升序对 (i >= 0)
        if (i >= 0) {
            // 从后往前找第一个大于 nums[i] 的元素 nums[j]
            // 由于 i 后面是降序的，所以从后往前找第一个大于 nums[i] 的即可
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 步骤 3: 反转 i+1 到数组末尾的部分
        // 如果步骤 1 没找到升序对 (i < 0)，则反转整个数组（变为升序，即最小排列）
        reverse(nums, i + 1, n - 1);
    }

    // 交换数组中两个位置的元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组指定范围 [left, right]
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
