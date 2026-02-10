package T200;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//示例 1：
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
//
//示例 2：
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
//
//此外，你可以假设该网格的四条边均被水包围。
public class Solution {
    public void dfs(char[][] grid,int i,int j){
        //防止 i 和 j 越界，当遍历到海洋的时候也退出循环
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        //将遍历过的陆地改为海洋，防止重复遍历
        grid[i][j]='0';
        //上，
        dfs(grid,i+1,j);
        //下
        dfs(grid,i-1,j);
        //右
        dfs(grid,i,j+1);
        //左
        dfs(grid,i,j-1);

    }

    public int numIslands(char[][] grid) {
        //异常处理
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //岛屿数量
        int ans = 0;
        for(int r=0;r < grid.length;r++){
            for(int c=0;c < grid[0].length;c++){
                if(grid[r][c] == '1'){
                    //深搜，遍历陆地
                    dfs(grid,r,c);
                    ans++;
                }
            }
        }
        return ans;
    }
}
