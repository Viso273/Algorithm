package T56;

public class Test {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}
