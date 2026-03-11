package T4;

public class Test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,3};
        System.out.println(Solution.findMedianSortedArraysMax(nums1,nums2));
        System.out.println(Solution.findMedianSortedArrays(nums1,nums2));
    }
}
