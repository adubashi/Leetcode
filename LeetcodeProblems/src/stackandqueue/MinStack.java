package stackandqueue;

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> myStack;
	private Stack<Integer> minStack;
	
	/** initialize your data structure here. */
    public MinStack() {
    		myStack = new Stack<>();
    		minStack = new Stack<>();
        
    }
    
    public void push(int x) {
    		if (x <= getMin()) {
			minStack.push(x);
		}
    		myStack.push(x);
    }
    
    public void pop() {
    		Integer n = myStack.pop();
    		if(n <= minStack.peek()) {
    			minStack.pop();
    		}
    }
    
    public int top() {
    	return myStack.peek();
    }
    
    public int getMin() {
    	if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
    }

}
