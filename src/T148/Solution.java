package T148;

import Objects.ListNode;

import java.util.Arrays;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//示例 1：
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//示例 2：
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//示例 3：
//输入：head = []
//输出：[]
//
public class Solution {
    // 最简单思路：取出来然后排序，再放进去
    // 遍历链表，获取节点中存放的值
    // 对取出的值进行排序
    // 排完序后放回
    public static ListNode sortList1(ListNode head) {
        // 获取链表长度
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        // 存放链表中的值
        int[] nums = new int[n];
        ListNode dummyNode = head;
        int i = 0;
        // 遍历链表，获取节点中存放的值
        while(dummyNode!=null && i<n){
            nums[i] = dummyNode.val;
            dummyNode = dummyNode.next;
            i++;
        }
        dummyNode = head;
        // 对取出的值进行排序
        Arrays.sort(nums);
        int j = 0;
        // 排完序后放回
        while(dummyNode!=null && j<n){
            dummyNode.val = nums[j];
            dummyNode = dummyNode.next;
            j++;
        }
        return head;
    }



    // 归并排序（自底向上）在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
    public ListNode sortList(ListNode head) {
        // 确定链表长度
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        // 用迭代 + 子链表长度翻倍的方式实现分治
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            // 每一段切割的起点
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                // 前半段
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 后半段
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 断开后半段
                ListNode next = null;
                if (curr != null) {
                    // 保留下一次合并的起点
                    next = curr.next;
                    curr.next = null;
                }
                // 合并这两段
                ListNode merged = merge(head1, head2);
                // 返回合并结果
                prev.next = merged;
                // prev走到这次合并结尾，用于下一次合并
                while (prev.next != null) {
                    prev = prev.next;
                }
                // cur跳到下一组合并的起点
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        // 双指针用于合并
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}
