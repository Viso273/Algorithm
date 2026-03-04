package T160;

import Objects.ListNode;

public class Test {
    public static void main(String[] args) {
        ListNode[] nodes = createTestCase();
        ListNode headA = nodes[0];
        ListNode headB = nodes[1];
        ListNode intersection = nodes[2];

        System.out.println("链表 A: " + headA);
        System.out.println("链表 B: " + headB);
        System.out.println("交点节点值: " + (intersection != null ? intersection.val : "null"));
    }

    public static ListNode[] createTestCase() {
        // 公共部分：8 → 4 → 5
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // 链表 A 前半部分：4 → 1 → (接公共部分)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;   // skipA = 2，所以接在第3个节点

        // 链表 B 前半部分：5 → 6 → 1 → (接公共部分)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;  // skipB = 3，所以接在第4个节点

        return new ListNode[]{headA, headB, intersect};
    }
}
