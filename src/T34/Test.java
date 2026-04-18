package T34;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = Solution.searchRange(nums,8);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}
