package T82;

import Objects.ListNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListNode head = ListNode.of(1,2,3,4,4,5);
        Solution solution = new Solution();
        System.out.println(solution.deleteDuplicates(head));
    }
}
