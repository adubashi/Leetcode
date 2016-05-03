package Problems;


import java.util.*;

public class implementAqueueUsingStacks232 {
	
	// Push element x to the back of queue.
    Stack<Integer> stackNewest = new Stack<Integer>();
    Stack<Integer> stackOldest = new Stack<Integer>();
    
    public void push(int x) {
        stackNewest.push(x);
        
    }

    // Removes the element from in front of queue.
    public void pop() {
        shiftStacks();
        stackOldest.pop();
        
    }
    
    //Shift stacks
    public void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return 0 == (stackOldest.size() + stackNewest.size());
        
    }

}
