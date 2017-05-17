package Stack.implementAstackUsingQueues225;

import java.util.*;

public class MyStack {
	
	 Queue<Integer> q = new LinkedList<Integer>();
	 Queue<Integer> tmp = new LinkedList<Integer>();

	// Push element x onto stack.
    public void push(int x) {
    	if(q.isEmpty()){
    		q.add(x);
    	} else {
    		int size = q.size();
    		
    		int i = 0;
    		while(i < size ){
    			tmp.add(q.remove());
    			i++;
    		}
    		q.add(x);
    		i = 0;
    		while(i < size){
    			q.add(tmp.remove());
    			i++;
    		} 		
    	}   
    }

    // Removes the element on top of the stack.
    public void pop() {
    	q.remove();
    }

    // Get the top element.
    public int top() {
    	return q.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	return q.isEmpty();
        
    }
}
