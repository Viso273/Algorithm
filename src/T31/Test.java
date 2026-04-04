package T31;
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        solution.nextPermutation(nums);
        for(int i:nums) System.out.print(i+" ");
    }
}
