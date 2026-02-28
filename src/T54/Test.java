package T54;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        List<Integer> ans = solution.spiralOrder(matrix);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
