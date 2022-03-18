package com.fengyq.leetcode;

import java.util.HashMap;

public class LongestWord {
//	720. 词典中最长的单词
//	给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
//	若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
//	输入: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//	输出: "apple"
//	解释: "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
	public static void main(String[] args) {
		String[] words ={"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
		System.out.println(longestWord(words));
	}
	
	public static String longestWord(String[] words) {
		Trie trie=new Trie();
		for (int i = 0; i < words.length; i++) {
			trie.insert(words[i]);
		}
		int longestLen=0;
		String longestWord="";
		for (int i = 0; i < words.length; i++) {
			if(trie.everyPrefixIsEnd(words[i])) {
				//单词长度一样，比较字典序
				if(words[i].length()>longestLen||(words[i].length()==longestLen&&dictSort(words[i],longestWord))){
					longestLen=words[i].length();
					longestWord=words[i];
				}
			}
		}
		return longestWord;
	}
	
	private static boolean dictSort(String word, String longestWord) {
		for (int i = 0; i < word.length()&&i<longestWord.length(); i++) {
			if(word.charAt(i)-longestWord.charAt(i)<0) {
				return true;
			}else if(word.charAt(i)-longestWord.charAt(i)>0) {
				return false;
			}
		}
		return true;
	}

	static class Trie {
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
	    
	    public boolean everyPrefixIsEnd(String word) {
	    	TrieNode node=root;
	    	for (int i = 0; i < word.length(); i++) {
				if(!node.childMap.containsKey(word.charAt(i))) {
					return false;
				}else {
					node=node.childMap.get(word.charAt(i));
					if(!node.endFlag) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
