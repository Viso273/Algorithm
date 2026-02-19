package T236;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
//最近公共祖先表示为一个节点 x，
//满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//示例 1：
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//示例 2：
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//示例 3：
//输入：root = [1,2], p = 1, q = 2
//输出：1

import Objects.TreeNode;

import java.util.*;

// 方法二：存储路径
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // 1. 记录每个节点的父节点（可以用 BFS 或 DFS）
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.offer(root);

        // 只要还没找到 p 和 q 就继续遍历（提早结束优化）
        // 将树放进队列中，p和q全放进队列的时候结束
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        // 2. 把 p 的所有祖先（包含自己）放入 set
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode cur = p;
        while (cur != null) {
            ancestors.add(cur);
            cur = parent.get(cur);
        }

        // 3. 从 q 往上走，第一个出现在 set 中的就是 LCA
        cur = q;
        while (cur != null) {
            if (ancestors.contains(cur)) {
                return cur;
            }
            cur = parent.get(cur);
        }

        return null; // 理论上不会走到这里（题目保证存在）
    }
}
