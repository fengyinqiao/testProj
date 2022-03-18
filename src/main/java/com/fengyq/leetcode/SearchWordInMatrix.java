package com.fengyq.leetcode;
//79. 单词搜索
//同类型，「力扣」第 130 题：被围绕的区域、「力扣」第 200 题：岛屿数量。
/*给定一个二维网格和一个单词，找出该单词是否存在于网格中。
        单词必须按照字母顺序，通过相邻的单元格内的字母构成，
        其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
        示例:
        board =
        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]
        给定 word = "ABCCED", 返回 true.
        给定 word = "SEE", 返回 true.
        给定 word = "ABCB", 返回 false.*/
public class SearchWordInMatrix {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'},
                          };
        String word="ABCCED";
        System.out.println(exist(board,word));
    }
    private static boolean dfs(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if(i<0||i>board.length-1||j<0||j>board[i].length-1||visited[i][j]) {
            return false;
        }
        if(k>word.length()-1||board[i][j]!=word.charAt(k)) {
            return false;
        }
        visited[i][j]=true;
        if(k==word.length()-1) {
            return true;
        }
        if(dfs(board,i,j+1,word,k+1, visited)) {//右
            return true;
        }
        if(dfs(board,i+1,j,word,k+1, visited)) {//下
            return true;
        }
        if(dfs(board,i,j-1,word,k+1, visited)) {//左
            return true;
        }
        if(dfs(board,i-1,j,word,k+1, visited)) {//上
            return true;
        }
        visited[i][j]=false;
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        if(board==null||word==null||"".equals(word)) {
            return false;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if (dfs(board,i,j,word,0,visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
