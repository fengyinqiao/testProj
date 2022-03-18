package com.fengyq.leetcode;

/*你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。
每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
        为了使收益最大化，矿工需要按以下规则来开采黄金：
        每当矿工进入一个单元，就会收集该单元格中的所有黄金。
        矿工每次可以从当前位置向上下左右四个方向走。
        每个单元格只能被开采（进入）一次。
        不得开采（进入）黄金数目为 0 的单元格。
        矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
        示例 1：
        输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
        输出：24
        解释：
        [[0,6,0],
        [5,8,7],
        [0,9,0]]
        一种收集最多黄金的路线是：9 -> 8 -> 7。
        示例 2：
        输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        输出：28
        解释：
        [[1,0,7],
        [2,0,6],
        [3,4,5],
        [0,3,0],
        [9,0,20]]
        一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。*/
public class MaximumGold {
    static boolean[][] visited;
    public static void main(String[] args) {
        /*int[][] grid={{1,0,7},
                      {2,0,6},
                      {3,4,5},
                      {0,3,0},
                      {9,0,20}};*/
        int[][] grid={{0,6,0},
                      {5,8,7},
                      {0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
    private static int dfs(int[][] grid, int i, int j) {
        if(i<0||i>grid.length-1||j<0||j>grid[i].length-1||grid[i][j]==0||visited[i][j]) {
            return 0;
        }
        visited[i][j]=true;
        int right,down,left,up,res;
        right=dfs(grid,i,j+1);
        down=dfs(grid,i+1,j);
        left=dfs(grid,i,j-1);
        up=dfs(grid,i-1,j);
        res=Math.max(Math.max(right, down),Math.max(left, up))+grid[i][j];
        visited[i][j]=false;
        return res;
    }
    public static int getMaximumGold(int[][] grid) {
        if(grid==null||grid[0]==null) {
            return 0;
        }
        int res=0;
        visited=new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt!=0) {
                    res=Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }
}
