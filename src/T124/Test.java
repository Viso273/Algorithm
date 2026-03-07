package T124;

import Objects.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(solution.maxPathSum(t));
    }
}
