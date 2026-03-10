package T19;

import Objects.ListNode;

import java.util.List;

// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//示例 1：
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//示例 2：
//输入：head = [1], n = 1
//输出：[]
//
//示例 3：
//输入：head = [1,2], n = 1
//输出：[1]
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        //思路：采用快慢双指针进行定位
        //虚拟节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        //快慢指针
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        //快指针领先n+1个节点
        for(int i=0;i<n+1;i++){
            fast = fast.next;
        }
        //定位
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //删除
        if(slow.next!=null) slow.next=slow.next.next;

        return dummyNode.next;
    }
}
