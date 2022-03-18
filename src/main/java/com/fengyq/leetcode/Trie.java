package com.fengyq.leetcode;

import java.util.HashMap;

class Trie {
	
	/**208. 实现 Trie (前缀树)
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
//	Trie trie = new Trie();
//
//	trie.insert("apple");
//	trie.search("apple");   // 返回 true
//	trie.search("app");     // 返回 false
//	trie.startsWith("app"); // 返回 true
//	trie.insert("app");   
//	trie.search("app");     // 返回 true

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 true
		System.out.println(trie.search("app"));     // 返回 false
		System.out.println(trie.startsWith("app")); // 返回 true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // 返回 true
	}
	
	static class TrieNode {
		int cnt;
        HashMap<Character,TrieNode> childMap;
        boolean endFlag;
        public TrieNode() {
        	childMap=new HashMap<Character, Trie.TrieNode>();
        	cnt=1;
        	endFlag=false;
		}
	}
	TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
    	for (int i = 0; i < word.length(); i++) {
    		//判断节点的子节点Map中是否包含指定字符所对应的子节点，如果不包含，新建子节点，放入map中
    		//如果包含，取出子节点，将子节点出现次数加1
			if(!node.childMap.containsKey(word.charAt(i))) {
				node.childMap.put(word.charAt(i), new TrieNode());
			}else {
				node.childMap.get(word.charAt(i)).cnt++;
			}
			node=node.childMap.get(word.charAt(i));
		}
    	node.endFlag=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node=root;
    	for (int i = 0; i < word.length(); i++) {
			if(!node.childMap.containsKey(word.charAt(i))) {
				return false;
			}else {
				node=node.childMap.get(word.charAt(i));
			}
		}
    	if(node.endFlag) {
    		return true;
    	}
		return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node=root;
    	for (int i = 0; i < prefix.length(); i++) {
			if(!node.childMap.containsKey(prefix.charAt(i))) {
				return false;
			}else {
				node=node.childMap.get(prefix.charAt(i));
			}
		}
		return true;
    }
}


