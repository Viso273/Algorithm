package Objects;

// ListNode基础定义
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 输出链表
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) sb.append(" → ");
            p = p.next;
        }
        return sb.toString();
    }
}
