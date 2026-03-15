package T22;

import java.util.ArrayList;
import java.util.List;
//数字 n 代表生成括号的对数，请你设计一个函数，
//用于能够生成所有可能的并且 有效的 括号组合。
//
//示例 1：
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//示例 2：
//输入：n = 1
//输出：["()"]
public class Solution {
    // 回溯法解决
    public List<String> generateParenthesis(int n) {
        // 返回结果
        List<String> res = new ArrayList<>();
        // 收集每一条路径
        char[] path = new char[n*2];
        // 回溯遍历
        dfs(0,0,n,path,res);

        return res;
    }

    private  void dfs(int left, int right, int n, char[] path, List<String> res) {
        // 回溯结束
        if(right==n){
            res.add(new String(path));
            return;
        }
        // 向左
        if(left<n){  //左边还可以添加左括号
            path[left+right] = '(';
            dfs(left+1,right,n,path,res);
        }
        // 向右
        if(right<left){  //右边还可以添加右括号
            path[left+right] = ')';
            dfs(left,right+1,n,path,res);
        }
    }
}
