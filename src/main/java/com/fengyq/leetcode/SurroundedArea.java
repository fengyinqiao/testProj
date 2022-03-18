package com.fengyq.leetcode;
/*给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
        示例:
        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：
        X X X X
        X X X X
        X X X X
        X O X X
        解释:
        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
        任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
        如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。*/
public class SurroundedArea {
    public static void main(String[] args) {
        char[][] board={
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','X','O','X'}};

        solve(board);
        print(board);
    }
    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void dfs(char[][] board, int i, int j) {
        if((i>=0&&i<=board.length-1&&j>=0&&j<=board[i].length-1)&&board[i][j]=='O') {
            board[i][j]='#';
            dfs(board, i, j+1);//右
            dfs(board, i+1, j);//下
            dfs(board, i, j-1);//左
            dfs(board, i-1, j);//上
        }
    }
    public static void solve(char[][] board) {
        if(board==null) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if(i==0||i==board.length-1||j==0||j==board[i].length-1) {
                    dfs(board,i,j);
                }
            }
        }
        print(board);
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }else if(board[i][j]=='#') {
                    board[i][j]='O';
                }
            }
        }
    }
}
