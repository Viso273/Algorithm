package T143;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//L0 → L1 → … → Ln - 1 → Ln
//请将其重新排列后变为：
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例 1：
//输入：head = [1,2,3,4]
//输出：[1,4,2,3]
//
//示例 2：
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3]

import Objects.ListNode;

//思路： 分三步走
//1，寻找中间点将链表切割为前半和后半
//2，将后半链表翻转
//3，合并两个链表
public class Solution {
    public void reorderList(ListNode head) {
        //空链表处理
        if(head == null) return;

        //寻找中间节点
        ListNode mid = midNode(head);

        //前半个链表节点
        ListNode l1 = head;
        //后半个链表节点
        ListNode l2 = mid.next;

        //从中间断开链表
        mid.next = null;

        //翻转后半链表
        l2 = reverseList(l2);

        //合并两个链表
        mergeList(l1,l2);
    }

    //处理相关函数
    //利用快慢指针查找中间节点
    public ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //翻转链表
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //合并两个链表
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
