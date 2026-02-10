package T206;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//示例 1：
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//示例 2：
//输入：head = [1,2]
//输出：[2,1]
//
//示例 3：
//
//输入：head = []
//输出：[]

import Objects.ListNode;

public class Test {
    public static void main(String[] args) {
        //用尾指针方式创建链表
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int[] number = {1,2,3,4,5};
        for(int num:number){
            tail.next = new ListNode(num);
            tail = tail.next;
        }
        ListNode head = dummy.next;

        //得到反转后的链表
        ListNode headReverse = reverseList(head);
        //输出结果
        ListNode ptr = headReverse;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //创建指针，暂存下一个节点信息
            ListNode aNode = curr.next;
            //转向
            curr.next = prev;

            //指针系统复位
            prev = curr;
            curr = aNode;
        }
        return prev;
    }
}
