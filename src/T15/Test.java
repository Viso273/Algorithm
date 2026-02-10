package T15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组
//注意：答案中不可以包含重复的三元组。
//
//示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//
//示例 2：
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
//
//示例 3：
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
public class Test {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //创建返回结果
        List<List<Integer>> rtn = new ArrayList<>();
        //将数组排序
        Arrays.sort(nums);
        //从头开始遍历数组
        for (int i = 0; i < nums.length; i++) {
            //排除不可能的情况
            if (nums[i] > 0) return rtn;
            //第一个元素去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //设置第二第三个元素的位置索引
            int left = i + 1;
            int right = nums.length - 1;
            //将该循环里的其他情况走完
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    //获取结果
                    rtn.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //第二三个元素去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    //继续前进
                    right--;
                    left++;
                }
            }
        }
        //返回
        return rtn;
    }
}
