package T215;

import java.util.Comparator;
import java.util.PriorityQueue;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//示例 1:
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//
//示例 2:
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4

public class Test {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,4));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 维护大小为 k 的最小堆，使用优先级队列实现
        // PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        // PriorityQueue 默认最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // 也可以改为最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,Comparator.reverseOrder());
        //放入前k个数进行初始化
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        int n = nums.length;
        for (int i = k; i < n; i++) {
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > minHeap.peek()) {
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}

