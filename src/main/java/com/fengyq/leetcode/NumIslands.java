package com.fengyq.leetcode;
/*给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
        一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
        你可以假设网格的四个边均被水包围。
        示例 1:输入:
        11110
        11010
        11000
        00000 输出: 1
        示例 2:输入:
        11000
        11000
        00100
        00011 输出: 3*/
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    private static boolean dfs(char[][] grid, int i, int j) {
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]=='0') {
            return false;
        }
        grid[i][j]='0';
        dfs(grid, i, j+1);//右
        dfs(grid, i+1, j);//下
        dfs(grid, i, j-1);//左
        dfs(grid, i-1, j);//上
        return true;
    }
    public static int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) {
            return 0;
        }
        int num=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(dfs(grid,i,j)) {
                    num++;
                }
            }
        }
        return num;
    }
}
