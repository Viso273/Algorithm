package T141;

import Objects.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode();
        head.val = 3;
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(s.hasCycle(head));
    }
}
