package com.fengyq.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
	
	List<Integer> list;
	int idx;
    public BSTIterator(TreeNode root) {
        list=inorderTraversal(root);
        idx=-1;
    }
    
    private List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list=new ArrayList<Integer>();
    	if(root==null) {
    		return list;
    	}
    	list.addAll(inorderTraversal(root.left));
    	list.add(root.val);
    	list.addAll(inorderTraversal(root.right));
		return list;
	}

	/** @return the next smallest number */
    public int next() {
    	return list.get(++idx);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if((idx+1)<list.size()) {
    		return true;
    	}
		return false;
    }
}
