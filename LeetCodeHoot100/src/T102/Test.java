package T102;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
// （即逐层地，从左到右访问所有节输入：
//示例 1：
//root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//示例 2：
//输入：root = [1]
//输出：[[1]]
//
//示例 3：
//输入：root = []
//输出：[]


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }

}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //二维数组记录结果
        List<List<Integer>> list = new ArrayList<>();
        //队列用于更新当前层与下一层
        Deque<TreeNode> que = new LinkedList<>();
        //处理异常
        if (root == null) {
            return list;
        }
        //遍历
        que.addLast(root);
        while (!que.isEmpty()) {
            //返回当前层
            List<Integer> levelList = new ArrayList<>();
            //获取当前层元素数量的快照
            int levelSize = que.size();
            //这里不能直接用que.size()，因为队列大小在不断变化
            for (int i = 0; i < levelSize; i++) {
                TreeNode peek = que.peekFirst();
                //记录队首的节点
                levelList.add(que.pollFirst().val);
                //将该节点的左右子节点放入队列尾部
                if (peek.left != null) {
                    que.offerLast(peek.left);
                }
                if (peek.right != null) {
                    que.offerLast(peek.right);
                }
            }
            //将当前层记录
            list.add(levelList);
        }
        //返回
        return list;

    }
}

