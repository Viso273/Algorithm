package T22;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(3);
        for (String s:ans){
            System.out.print(s + " ");
        }
    }
}

