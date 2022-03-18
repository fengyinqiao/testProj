package com.fengyq.leetcode;

class MinStack {
	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
	//
	//push(x)?-- 将元素 x 推入栈中。
	//pop()?-- 删除栈顶的元素。
	//top()?-- 获取栈顶元素。
	//getMin() -- 检索栈中的最小元素。
	//示例:
	//
	//MinStack minStack = new MinStack();
	//minStack.push(-2);
	//minStack.push(0);
	//minStack.push(-3);
	//minStack.getMin();   --> 返回 -3.
	//minStack.pop();
	//minStack.top();      --> 返回 0.
	//minStack.getMin();   --> 返回 -2.
    /** initialize your data structure here. */
	int[] a;
	int top;
    public MinStack() {
    	a=new int[10000];
    	top=0;
    }
    
    public void push(int x) {
        a[top++]=x;
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
    	if(top>0){
    		return a[top-1];
    	}
		return -1;
        
    }
    
    public int getMin() {
    	int min=a[0];
    	for (int i = 0; i < top; i++) {
			if(a[i]<min){
				min=a[i];
			}
		}
		return min;
    }
}


