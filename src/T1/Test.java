package T1;

public class Test {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        for(int i: res) System.out.println(i);
    }
}
