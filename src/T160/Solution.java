package T160;

import Objects.ListNode;
//给你两个单链表的头节点 headA 和 headB ，
// =请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //两个指针将非公共部分都遍历一遍，
        //走过的距离相同，所以会在交点处相遇
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
