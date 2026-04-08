package T2;


import Objects.ListNode;


public class Test {
    public static void main(String[] args) {
        ListNode l1 = ListNode.of(2,4,3);
        ListNode l2 = ListNode.of(5,6,4);
        System.out.println(Solution.addTwoNumbers(l1,l2).toString());

    }
}
