package com.fengyq.leetcode;

public class DeleteBST_Unsettled {
//	root = [5,3,6,2,4,null,7]
//	        key = 3
//	            5
//	           / \
//	          3   6
//	         / \   \
//	        2   4   7
//	        给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//	        一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//	            5
//	           / \
//	          4   6
//	         /     \
//	        2       7
//	        另一个正确答案是 [5,2,6,null,4,null,7]。
//	            5
//	           / \
//	          2   6
//	           \   \
//	            4   7
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode parant=searchParant(root,key);
		if(parant==null) {
			return null;
		}
		if(parant.left!=null&&parant.left.val==key&&parant.right==null) {
			parant.left=null;
		}
		if(parant.right!=null&&parant.right.val==key&&parant.left==null) {
			parant.right=null;
		}
		if(parant.right!=null&&parant.right.val==key){
			if(parant.right.left==null) {
				parant.right=parant.right.right;
			}else if(parant.right.right==null) {
				parant.right=parant.right.left;
			}
		}else if(parant.left!=null&&parant.left.val==key){
			if(parant.left.left==null) {
				parant.left=parant.left.right;
			}else if(parant.left.right==null) {
				parant.left=parant.left.left;
			}
		}else if(parant.left!=null&&parant.left.val==key){
			if(parant.left.left!=null&&parant.left.right!=null) {
				TreeNode keyRight=parant.left.right;
				while(keyRight!=null){
					keyRight=keyRight.left;
				}
				
			}
		}
		
		
		return root;
	}
	public TreeNode searchParant(TreeNode root, int val) {
		if(root==null) {
			return null;
		}
		if(root.left==null&&root.right==null) {
			return null;
		}
		if(root.left!=null&&root.left.val==val||root.right!=null&&root.right.val==val) {
			return root;
		}
		if(val<root.val) {
			return searchParant(root.left,val);
		}
		if(val>root.val) {
			return searchParant(root.right,val);
		}
		return null;
	}
}
