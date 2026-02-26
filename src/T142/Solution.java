package T142;

import Objects.ListNode;

//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。
//如果链表无环，则返回 null。
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置
//（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
//注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//不允许修改 链表。
//
//示例 1：
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//示例 2：
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//示例 3：
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
public class Solution {
    //思路：保持快慢指针之间的速度差为1，这样在慢指针进入环的起点的时候能将非环部分的长度存入二者的距离之间，
    //     这样当快慢指针相遇的时候快指针追上慢指针跑过的距离即为环的总长度减去非环长度，
    //     此时慢指针距离环的起始点的长度正好为非环部分的长度
    //     再用新的指向头节点的指针与慢指针同步前进来找到环的起始点
    //     快慢指针相遇的时候慢指针距离环的起始点的长度正好为非环部分长度，所以代码中的ptr指针和满指针必定会相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            //注意此处的异常处理
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
