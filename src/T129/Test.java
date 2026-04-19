package T129;

import Objects.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right= new TreeNode(3);
        Solution sl = new Solution();
        System.out.println(sl.sumNumbers(node));
    }
}
