package T19;

import Objects.ListNode;

import java.util.List;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        System.out.println(ListNode.of(1,2,3,4,5));
        System.out.println(Solution.removeNthFromEnd(ListNode.of(1,2,3,4,5),2));
    }
}
