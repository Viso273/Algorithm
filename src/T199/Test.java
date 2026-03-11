package T199;

import Objects.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(4);
        System.out.println(Solution.rightSideView(t).toString());
    }
}
