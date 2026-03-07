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

import Objects.TreeNode;


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


