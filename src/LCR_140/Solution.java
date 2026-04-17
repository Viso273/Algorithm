package LCR_140;

import Objects.ListNode;

//给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，
//请查找并返回倒数第 cnt 个训练项目编号对应的节点。
//
//示例 1：
//输入：head = [2,4,7,8], cnt = 1
//输出：8
class Solution {
    public static ListNode trainingPlan(ListNode head, int k) {
        ListNode left = head, right = head;
        while (k-- > 0) right = right.next; // 右指针先向右走 k 步
        // 然后一起走，右指针走到空节点时，左指针正好就在倒数第 k 个节点
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}

