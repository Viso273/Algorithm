package T21;

public class Test {
    //示例1：
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //
    //示例 2：
    //输入：l1 = [], l2 = []
    //输出：[]
    //
    //示例 3：
    //输入：l1 = [], l2 = [0]
    //输出：[0]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 引入哨兵节点
        ListNode dummyNode = new ListNode();
        ListNode ptr = dummyNode; // 用于遍历的指针

        // 遍历建表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        //处理多出来的一截
        if (l1 != null) {
            ptr.next = l1;
        } else if (l2 != null) {
            ptr.next = l2;
        }

        // 返回头结点
        return dummyNode.next;
    }
}
