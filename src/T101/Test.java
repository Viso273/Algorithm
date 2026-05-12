package T101;

import Objects.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(3);
        tr.right.left = new TreeNode(4);
        System.out.println(new Solution().isSymmetric(tr));
    }
}
