package T143;

import Objects.ListNode;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        solution.reorderList(dummy.next);
        while (dummy.next != null) {
            System.out.print(dummy.next.val + " ");
            dummy = dummy.next;
        }
    }
}
