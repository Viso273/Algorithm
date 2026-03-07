package T124;
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
// 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//路径和 是路径中各节点值的总和。
//给你一个二叉树的根节点 root ，返回其 最大路径和
//
//示例 1：
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//
//示例 2：
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
import Objects.TreeNode;

public class Solution {
    int count = Integer.MIN_VALUE;
    // 递归收集路径
    // 递归路径上直接进行求节点值总和
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return count;
    }

    public int maxGain(TreeNode t){
        if(t==null) return 0;
        int left = Math.max(maxGain(t.left),0);
        int right = Math.max(maxGain(t.right),0);
        // 该节点的最大路径和
        int maxPrice = left+right+t.val;
        count = Math.max(count,maxPrice);
        // 左右子节点的最大贡献值只能选择一个方向上的
        return t.val+Math.max(left,right);
    }
}
