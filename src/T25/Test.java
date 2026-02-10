package T25;
import Objects.ListNode;
//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//你不能只是单纯地改变节点内部的值，而是需要实际进行节点交换。
//
//示例 1：
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//示例 2：
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
public class Test {
    public static void main(String[] args) {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 获取链表长度
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }

        // 设置哨兵节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p0 = dummyNode;  // p0指向当前组的前一个节点

        // 循环处理每组k个节点
        while (n >= k) {
            n -= k;

            // 翻转当前组的k个节点
            ListNode pre = null;  // 不需要new，直接赋值为null
            ListNode cur = p0.next;  // 当前组的第一个节点

            // 翻转k个节点
            for (int i = 0; i < k; i++) {
                // 临时保存下一个节点
                ListNode nxt = cur.next;
                // 翻转当前节点的指向
                cur.next = pre;
                // 移动pre和cur
                pre = cur;
                cur = nxt;
            }
            //===================难点===============================//
            // 连接翻转后的部分
            // 保存当前组的第一个节点（翻转后变成最后一个节点）
            ListNode groupStart = p0.next;
            // 连接：当前组的最后一个节点指向下一组的第一个节点
            groupStart.next = cur;
            // 连接：前一组（p0）指向当前组翻转后的头节点
            p0.next = pre;
            // p0移动到下一组的前一个节点（即当前组的最后一个节点）
            p0 = groupStart;
        }

        // 返回头节点
        return dummyNode.next;
    }
}


