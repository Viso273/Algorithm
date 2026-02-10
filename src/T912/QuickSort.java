package T912;
//给你一个整数数组 nums，请你将该数组升序排列。
//你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
//
//示例 1：
//输入：nums = [5,2,3,1]//输出：[1,2,3,5]
//解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
//
//示例 2：
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//解释：请注意，nums 的值不一定唯一。
import java.util.Random;

// 快速排序
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] res = sortArray(nums);
        for (int i: res){
            System.out.print(i + " ");
        }
    }

    private static final Random rand = new Random();
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 快速排序子数组 [left, right]
    private static void quickSort(int[] nums, int left, int right) {
        // 优化：如果子数组已是升序，直接返回
        boolean ordered = true;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[i + 1]) {
                ordered = false;
                break;
            }
        }
        if (ordered) {
            return;
        }

        int i = partition(nums, left, right); // 划分子数组
        quickSort(nums, left, i - 1);  // 排序在 pivot 左侧的元素
        quickSort(nums, i + 1, right); // 排序在 pivot 右侧的元素
    }

    // 在子数组 [left, right] 中随机选择一个基准元素 pivot
    // 根据 pivot 重新排列子数组 [left, right]
    // 重新排列后，<= pivot 的元素都在 pivot 的左侧，>= pivot 的元素都在 pivot 的右侧
    // 返回 pivot 在重新排列后的 nums 中的下标
    // 特别地，如果子数组的所有元素都等于 pivot，我们会返回子数组的中心下标，避免退化
    private static int partition(int[] nums, int left, int right) {
        // 1. 在子数组 [left, right] 中随机选择一个基准元素 pivot
        int i = left + rand.nextInt(right - left + 1);
        int pivot = nums[i];
        // 把 pivot 与子数组第一个元素交换，避免 pivot 干扰后续划分，从而简化实现逻辑
        swap(nums, i, left);

        // 2. 相向双指针遍历子数组 [left + 1, right]
        // 循环不变量：在循环过程中，子数组的数据分布始终如下图
        // [ pivot | <=pivot | 尚未遍历 | >=pivot ]
        //   ^                 ^     ^         ^
        //   left              i     j         right

        i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            // 此时 nums[i] >= pivot

            while (i <= j && nums[j] > pivot) {
                j--;
            }
            // 此时 nums[j] <= pivot

            if (i >= j) {
                break;
            }

            // 维持循环不变量
            swap(nums, i, j);
            i++;
            j--;
        }

        // 循环结束后
        // [ pivot | <=pivot | >=pivot ]
        //   ^             ^   ^     ^
        //   left          j   i     right

        // 3. 把 pivot 与 nums[j] 交换，完成划分（partition）
        // 为什么与 j 交换？
        // 如果与 i 交换，可能会出现 i = right + 1 的情况，已经下标越界了，无法交换
        // 另一个原因是如果 nums[i] > pivot，交换会导致一个大于 pivot 的数出现在子数组最左边，不是有效划分
        // 与 j 交换，即使 j = left，交换也不会出错
        swap(nums, left, j);

        // 交换后
        // [ <=pivot | pivot | >=pivot ]
        //               ^
        //               j

        // 返回 pivot 的下标
        return j;
    }

    // 交换 nums[i] 与 nums[j]
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
