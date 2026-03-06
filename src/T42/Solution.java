package T42;

import java.util.Deque;
import java.util.LinkedList;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//示例 1：
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//示例 2：
//输入：height = [4,2,0,3,2,5]
//输出：9
public class Solution {
    // 单调栈解决
    // 采用类似贪心的思想，向前探索，寻找高低差
    // 通过维护一个递减的单调栈，栈内存放数组下标
    // 当遍历到比栈顶元素大的数的时候计算之前一块区域可以存放的最大水量
    public int trap(int[] height){
        int n = height.length;
        int res = 0;
        Deque<Integer> stack =new LinkedList<Integer>();

        for(int i=0;i<n;i++){
            // 当前遍历到的值比栈顶元素大
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 最低点坐标
                int top = stack.pop();
                // 两个元素是相邻的
                if(stack.isEmpty()) break;
                int left = stack.peek();
                // 求宽度
                int width = i-left-1;
                // 求深度
                int depth = Math.min(height[i],height[left]) - height[top];
                // 将算得的体积加入结果中
                res += width*depth;
            }
            // 当前遍历到的元素比栈顶元素小
            stack.push(i);
        }
        return res;
    }
}
