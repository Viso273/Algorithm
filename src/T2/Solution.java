package T2;

import Objects.ListNode;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//示例 1：
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//示例 2：
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//示例 3：
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //思路：直接相加
        //新链表的左右端点
        ListNode head = null;
        ListNode tail = null;

        //存储进位信息
        int pushNumber = 0;

        //创建链表
        while(l1 != null || l2!=null){
            // 获取两个数,这里不能直接赋值，会出现空指针异常
            int n1;
            int n2;
            n1 =  (l1 == null ? 0:l1.val);
            n2 =  (l2 == null ? 0:l2.val);
            // 获取当前位置上的值
            int sum = n1+n2+pushNumber;
            // 创建链表节点，此处要考虑初始化的情况
            if(head==null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            // 更新进位信息
            pushNumber = sum/10;
            // 更新数据链表
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        //处理最后的进位信息
        if(pushNumber!=0) tail.next = new ListNode(pushNumber);

        //返回头节点
        return head;
    }
}
