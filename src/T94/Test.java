package T94;

import Objects.TreeNode;

import javax.sound.midi.Soundbank;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Solution.inorderTraversal(root));
    }
}
