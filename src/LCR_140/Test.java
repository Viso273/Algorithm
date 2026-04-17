package LCR_140;

import Objects.ListNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ListNode ln = ListNode.of(2,4,7,8);
        System.out.println(Solution.trainingPlan(ln,1));
    }
}
