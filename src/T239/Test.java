package T239;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = solution.maxSlidingWindow(nums,3);
        for(int i : res){
            System.out.println(i);
        }
    }
}
