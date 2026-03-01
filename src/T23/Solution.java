package T23;

import Objects.ListNode;

// 你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//示例 1：
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//示例 2：
//输入：lists = []
//输出：[]
//
//示例 3：
//输入：lists = [[]]
//输出：[]
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    // 分治法合并区间 [left, right] 内的链表
    private ListNode mergeKListsHelper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];  // 只有一个链表，直接返回
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeKListsHelper(lists, left, mid);  // 左半部分合并
        ListNode rightList = mergeKListsHelper(lists, mid + 1, right);  // 右半部分合并
        return mergeTwoLists(leftList, rightList);  // 合并两个有序链表
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 将剩余部分接上
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummyNode.next;
    }
}
