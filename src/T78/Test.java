package T78;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.subsets(nums);
        for (List<Integer> l : res){
            System.out.print("[");
            for(int i=0;i<l.size();i++){
                if(i==l.size()-1) {
                    System.out.print(l.get(i));
                }else {
                    System.out.print(l.get(i) + " ");
                }
            }
            System.out.print("]");
        }
    }
}
