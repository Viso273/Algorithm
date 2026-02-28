package T54;

import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//示例 1：
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//示例 2：
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;

        int u = 0, d = matrix.length - 1;// 上下
        int l = 0, r = matrix[0].length - 1; // 左右

        while (true) {
            for (int i = l; i <= r; i++) { // 左->右
                ans.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) { // 上->下
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) { // 右->左
                ans.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) { // 下->上
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }
}
