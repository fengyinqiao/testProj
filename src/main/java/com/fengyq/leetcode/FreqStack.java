package com.fengyq.leetcode;

import java.util.HashMap;
import java.util.Stack;

/*
实现 FreqStack，模拟类似栈的数据结构的操作的一个类。FreqStack 有两个函数：
push(int x)，将整数 x 推入栈中。
pop()，它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
示例：
push [5,7,5,7,4,5]
pop() -> 返回 5，因为 5 是出现频率最高的。 栈变成 [5,7,5,7,4]。
pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。 栈变成 [5,7,5,4]。
pop() -> 返回 5 。 栈变成 [5,7,4]。
pop() -> 返回 4 。 栈变成 [5,7]。
*/
class FreqStack {
    //元素->出现频率
    HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
    //出现频率->所有拥有这个出现频率的元素所组成的栈
    HashMap<Integer, Stack<Integer>> group=new HashMap<Integer,Stack<Integer>>();
    int maxFreq=0;

    public FreqStack() {

    }

    public void push(int x) {
        Integer f=freq.get(x);
        if(f==null) {
            freq.put(x, 1);
        }else {
            freq.put(x, f+1);
        }
        f=freq.get(x);
        Stack<Integer> stack=group.get(f);
        if(stack==null) {
            stack=new Stack<Integer>();
            group.put(f, stack);
        }
        stack.push(x);
        if(f>maxFreq) {
            maxFreq=f;
        }
    }

    public int pop() {
        int x=0;
        Stack<Integer> maxFreqStack=group.get(maxFreq);
        if(maxFreqStack!=null&&maxFreqStack.size()!=0) {
            x=maxFreqStack.pop();
            freq.put(x, freq.get(x)-1);
            if(maxFreqStack.size()==0) {
                maxFreq--;
            }
        }
        return x;
    }
    public static void main(String[] args) {
        FreqStack freqStack=new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.print(freqStack.pop()+" ");
        System.out.print(freqStack.pop()+" ");
        System.out.print(freqStack.pop()+" ");
        System.out.print(freqStack.pop()+" ");
        System.out.print(freqStack.pop()+" ");
        System.out.print(freqStack.pop()+" ");
    }
}
