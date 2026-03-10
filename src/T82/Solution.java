package T82;

import Objects.ListNode;

// 给定一个已排序的链表的头 head ，
// 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//示例 1：
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//示例 2：
//输入：head = [1,1,1,2,3]
//输出：[2,3]
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 防止头节点被删
        ListNode dummyNode = new ListNode(0,head);
        // cur表示已经处理好的节点，即后续节点中不会出现和cur节点值相同的节点
        ListNode cur = dummyNode;
        // 由于节点已经排过序，所以对于连续的相同的节点，只用保留一个节点就可以了
        while(cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next.next.val == x && cur.next.next != null){
                    cur.next = cur.next.next;
                }
            }
            else{
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
