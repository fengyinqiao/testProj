package com.fengyq.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
//	LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//	cache.put(1, 1);
//	cache.put(2, 2);
//	cache.get(1);       // 返回  1
//	cache.put(3, 3);    // 该操作会使得密钥 2 作废
//	cache.get(2);       // 返回 -1 (未找到)
//	cache.put(4, 4);    // 该操作会使得密钥 1 作废
//	cache.get(1);       // 返回 -1 (未找到)
//	cache.get(3);       // 返回  3
//	cache.get(4);       // 返回  4
	LinkedHashMap<Object, Integer> linkedHashMap;
	int capacity;
    public LRUCache(int capacity) {
    	this.linkedHashMap=new LinkedHashMap<Object, Integer>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
    	Integer result=linkedHashMap.get(key);
    	if(result!=null) {
    		linkedHashMap.remove(key);
    		linkedHashMap.put(key, result);
    		return result;
    	}else {
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
    	if(linkedHashMap.containsKey(key)) {
    		linkedHashMap.remove(key);
    	}
    	linkedHashMap.put(key, value);
    	if(linkedHashMap.size()>capacity) {
    		for (Map.Entry<Object, Integer> entry : linkedHashMap.entrySet()) {
				linkedHashMap.remove(entry.getKey());
				return;
			}
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);    // 该操作会使得密钥 2 作废
		System.out.println(cache.get(2));       // 返回 -1 (未找到)
		cache.put(4, 4);    // 该操作会使得密钥 1 作废
		cache.get(1);       // 返回 -1 (未找到)
		System.out.println(cache.get(3));        // 返回  3
		System.out.println(cache.get(4));     // 返回  4
    	
//    	System.out.println(cache.get(2)); 
//    	cache.put(2, 6);
//    	System.out.println(cache.get(1)); 
//    	cache.put(1, 5);
//    	cache.put(1, 2);
//    	System.out.println(cache.get(1)); 
//    	System.out.println(cache.get(2)); 
	}
}

