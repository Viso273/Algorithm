package T199;

import Objects.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，
//返回从右侧所能看到的节点值。
//
//示例 1：
//输入：root = [1,2,3,null,5,null,4]
//输出：[1,3,4]
//
//示例 2：
//输入：root = [1,2,3,4,null,null,null,5]
//输出：[1,3,4,5]
//解释：
//
//示例 3：
//输入：root = [1,null,3]
//输出：[1,3]
//
//示例 4：
//输入：root = []
//输出：[]
public class Solution {
    // 实际上是找每层最右边的节点
    // 层序遍历
    public static List<Integer> rightSideView(TreeNode root) {
        // 存放返回结果
        List<Integer> result = new ArrayList<>();
        // 异常处理
        if(root == null) return null;
        // 队列用于层序遍历
        Deque<TreeNode> list = new LinkedList<>();
        // 记录每层元素个数的变量
        int count = 0;
        // 初始化
        list.addLast(root);
        // 遍历当前层
        while(!list.isEmpty()){
            count = list.size();
            for (int i = 0; i < count; i++) {
                // 父节点出栈
                TreeNode temp = list.pollFirst();
                // 放入子节点
                if(temp.left!=null) list.addLast(temp.left);
                if(temp.right!=null) list.addLast(temp.right);
                // 将该层的最后一个节点，也就是最右边的节点放入结果中
                if(i==count-1){
                    result.add(temp.val);
                }
            }
        }
        return result;
    }

}
