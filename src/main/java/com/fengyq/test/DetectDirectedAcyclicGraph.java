package com.fengyq.test;

import java.util.ArrayList;

//  评测题目: 给定一组数据节点，每个节点使用中括号括起来，多个节点之间使用半角逗号分隔，
//  如下所示：
//  [1-2],[2-3],[3-4,5,6],[4-],[5-8],[6-7],[7-],[8-2]
//  节点内部结构使用“-”分隔，前半部分为节点ID，后半部分为该节点指向的节点，
//  如果没有指向，则为空，多个指向节点使用半角逗号分隔；
//  给定任意一组数据，请计算节点之间是否存在环？
//  如果存在环，直接结束；不存在环，则打印出每条路径。
//  mingkai.wmk@alibaba-inc.com 18678875617
public class DetectDirectedAcyclicGraph {
    //顶点
    static ArrayList<Integer> vertex=new ArrayList<>();
    //邻接矩阵
    static int[][] graph;
    //顶点个数
    static int vertexNum;
    //标记矩阵,0为当前结点未访问,1为访问过,-1表示当前结点后边的结点都被访问过。
    static int[] color;
    //是否有环
    static boolean hasCycle = true;
    //存路径
    static ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();

    //深搜遍历图
    static void DFS(int i,ArrayList<Integer> path){
        //System.out.println("正在访问结点"+i);
        color[i] = 1;//结点i变为访问过的状态
        path.add(i);
        Boolean isEnd=true;//是否访问到了终点
        for(int j = 1; j<= vertexNum; j++){
            if(graph[i][j] != 0){ //如果当前结点有指向的结点
                if(color[j] == 1){//并且已经被访问过
                    hasCycle = false;//有环
                    break;
                }else if(color[j] == -1){//当前结点后边的结点都被访问过，直接跳至下一个结点
                    continue;
                }else{
                    isEnd=false;
                    DFS(j,path);//否则递归访问
                }
            }
        }
        if(isEnd) {//访问到了终点，添加结果
            ArrayList resPath=new ArrayList(path);
            paths.add(resPath);
        }
        color[i] = -1;//遍历过所有相连的结点后，把本节点标记为-1。以后遇到该点，不再展开搜索，相当于记忆化搜索。
        path.remove(path.size()-1);//一定要记得回溯！！！
    }

    public static void main(String[] args) {
        String[] input={"1-2","2-3","3-4,5,6","4-","5-8","6-7","7-","8-"};
      //String[] input={"1-2","2-3","3-4,5,6","4-","5-8","6-7","7-","8-2"};
        parse(input);
        for(int i = 1; i<= vertexNum; i++){//保证每个节点都遍历到，排除有的结点没有边的情况
            if(color[i] == -1){//该结点后边的结点都被访问过了，跳过它
                continue;
            }
            ArrayList path=new ArrayList();
            DFS(i,path);
            if(!hasCycle){
                System.out.println("有环！！！");
                break;
            }
        }
        if(hasCycle){
            System.out.println("无环");
            printPaths(paths);
        }
    }

    static void printPaths(ArrayList<ArrayList<Integer>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            ArrayList<Integer> path =  paths.get(i);
            for (int j = 0; j < path.size(); j++) {
                System.out.print(path.get(j));
                if(j != path.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }
    }

    static void parse(String[] input) {
        vertexNum =input.length;
        graph=new int[vertexNum+1][vertexNum+1];
        color=new int[vertexNum+1];
        for (int i = 0; i < input.length; i++) {
            String[] edge=input[i].split("-");//边，左边是顶点，右边是相邻顶点（可能有多个）
            int vtx=Integer.parseInt(edge[0]);
            vertex.add(vtx);
            if(edge.length>1) {
                String[] adjVertexes=edge[1].split(",");//多个相邻顶点
                for (int j = 0; j < adjVertexes.length; j++) {
                    int adjVertex = Integer.parseInt(adjVertexes[j]);
                    graph[vtx][adjVertex]=1;
                }
            }
        }
    }
}
