package T236;

import Objects.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        Solution2 so2 = new Solution2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(sol.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(so2.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
