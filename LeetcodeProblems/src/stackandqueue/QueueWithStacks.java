package stackandqueue;

import java.util.*; 

/*
 * enQueue(q, x)
  1) While stack1 is not empty, push everything from stack1 to stack2.
  2) Push x to stack1 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.
Here time complexity will be O(n)

deQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it
Here time complexity will be O(1)
 */
public class QueueWithStacks {
	/** Initialize your data structure here. */
	
	private Stack<Integer> s1;
    private Stack<Integer> s2;
	
    public QueueWithStacks() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
	    	while (!s2.isEmpty()) {
	        s1.push(s2.pop());
	    	}
	    s1.push(x);  
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    		while (!s1.isEmpty()) {
            s2.push(s1.pop());
    		}
          
        return s2.pop();   
    }
    
    /** Get the front element. */
    public int peek() {
    		while (!s1.isEmpty()) {
            s2.push(s1.pop());
    		}
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    		return s1.isEmpty() && s2.isEmpty(); 
    }
}

/*
 *Slow enqueue operation: 
 * enQueue(q, x)
  1) While stack1 is not empty, push everything from stack1 to stack2.
  2) Push x to stack1 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.
Here time complexity will be O(n)

deQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it
Here time complexity will be O(1)
*
*/
