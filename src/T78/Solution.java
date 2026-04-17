package T78;
//给你一个整数数组 nums ，数组中的元素 互不相同 。
//返回该数组所有可能的子集（幂集）。
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//示例 1：
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//示例 2：
//输入：nums = [0]
//输出：[[],[0]]
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // 回溯算法解决
        // 返回结果
        List<List<Integer>> res = new ArrayList<>();
        // 使用回溯算法
        // 参数为：起始地址， 数据集， 结果集， 结果
        backTrace(0,nums,res,new ArrayList<Integer>());
        //返回
        return res;
    }

    private void backTrace(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> temp) {
        // 记录结果，使用深拷贝
        res.add(new ArrayList<>(temp));
        // 循环体
        for(int j=i;j< nums.length;j++) {
            // 处理当前层
            temp.add(nums[j]);
            // 进入下一层
            backTrace(j+1,nums,res,temp);
            // 达到该分支的末尾，向上回归，去往其他分支
            temp.remove(temp.size()-1);
        }
    }
}

