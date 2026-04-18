package T155;

public class Test {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(5);
        ms.push(9);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
