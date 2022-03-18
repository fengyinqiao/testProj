package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。*/
public class NTreeNodeLevelOrder {
    public static void main(String[] args) {
        List<List<Integer>> lists=levelOrder(new Node());
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrder2(Node root) {//递归
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(root==null) {
            return lists;
        }
        helper(root,0,lists);
        return lists;
    }

    private static void helper(Node root, int depth, List<List<Integer>> lists) {
        if(depth==lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth).add(root.val);
        List<Node> children=root.children;
        if(children!=null) {
            for (int i = 0; i < children.size(); i++) {
                helper(children.get(i), depth+1, lists);
            }
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {//迭代
        List lists=new ArrayList<List<Integer>>();
        if(root==null) {
            return lists;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueNums=queue.size();
            List<Integer> list=new ArrayList<Integer>();
            for (int i = 0; i < queueNums; i++) {
                Node node=queue.poll();
                List<Node> children=node.children;
                if(children!=null) {
                    for (int j = 0; j < children.size(); j++) {
                        queue.add(children.get(j));
                    }
                }
                list.add(node.val);
            }
            lists.add(list);
        }
        return lists;
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
