package com.fengyq.leetcode;

public class KthLargest_Unsettled {
	int k;
	TreeNode root;
	public KthLargest_Unsettled(int k, int[] nums) {
		this.k=k;
		this.root=null;
		for (int i = 0; i < nums.length; i++) {
			root=insertIntoBST(root, nums[i]);
		}
	}

	public int add(int val) {
		root=insertIntoBST(root, val);
		TreeNode parant=root;
		TreeNode node=parant.right;
		if(node==null) {
			node=root;
		}
		int i=k;
		while(node!=null){
			if(i>node.cnt+1){
				i=i-node.cnt-1;
				node=parant.left;
			}else if(i==node.cnt){
				return node.val;
			}else if(i<node.cnt){
				parant=node;
				node=node.right;
			}else if(i==node.cnt+1){
				return parant.val;
			}
		}
		return val;
	}
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; cnt=1;}
	    int cnt;
	}
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root==null) {
			return new TreeNode(val);
		}
		if(val<root.val) {
			root.left=insertIntoBST(root.left,val);
		}
		if(val>root.val) {
			root.right=insertIntoBST(root.right,val);
		}
		root.cnt++;
		return root;
	}
	
	public static void main(String[] args) {
//		int k = 3;
//		int[] arr = {4,5,8,2};
//		KthLargest_Unsettled kthLargestUnsettled = new KthLargest_Unsettled(3, arr);
//		System.out.println(kthLargestUnsettled.add(3));   // returns 4
//		System.out.println(kthLargestUnsettled.add(5));   // returns 5
//		System.out.println(kthLargestUnsettled.add(10));  // returns 5
//		System.out.println(kthLargestUnsettled.add(9));   // returns 8
//		System.out.println(kthLargestUnsettled.add(4));   // returns 8
		
		int k = 1;
		int[] arr = {-2};
		KthLargest_Unsettled kthLargestUnsettled = new KthLargest_Unsettled(1, arr);
		System.out.println(kthLargestUnsettled.add(-3));   // returns 4
		System.out.println(kthLargestUnsettled.add(0));   // returns 5
		System.out.println(kthLargestUnsettled.add(2));  // returns 5
		System.out.println(kthLargestUnsettled.add(-1));   // returns 8
		System.out.println(kthLargestUnsettled.add(4));   // returns 8
	}
}
