package ProblemsBasedOnDataStructures.Stack.nestedListIterator341;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;


public class NestedIterator implements Iterator<Integer> {
	
	//Holds onto the lists
	public Stack<NestedInteger> myStack = new Stack<NestedInteger>();

	public NestedIterator(List<NestedInteger> nestedList) {

    	for(int i = nestedList.size() - 1; i >= 0; i--){
    		myStack.push(nestedList.get(i));
    	}     
    }

    @Override
    public Integer next() {
    	NestedInteger myNestedInt = myStack.pop();
    	return myNestedInt.getInteger();
        
    }

    @Override
    public boolean hasNext() {
    	
    	//Stack is empty, list is empty
    	
    	while(!myStack.isEmpty()){
    	
	    	if(myStack.peek().isInteger()){
	    		return true;
	    	} else {
	    		List<NestedInteger> list = myStack.pop().getList();
	    		for(int i = list.size() - 1; i >= 0 ; i--){
	    			myStack.push(list.get(i));
	    		}	
	    	}   
    	}
    	
    	return false;
    }

}
