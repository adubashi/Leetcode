package Company1Search;

import java.util.*;
public class PeekingIterator implements Iterator<Integer> {
	
	
	private Integer next; //cache the next peek
    private Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iter = iterator;
	    //Initialize the cache
	    if (iter.hasNext()) {
	        next = iter.next();
	    }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ret = next;
	    if(iter.hasNext()){
	    	next = iter.next();
	    } else {
	    	next = null;
	    }
	    return ret;   
	}

	@Override
	public boolean hasNext() {
		return next != null;   
	}
	
	public void remove(){
		
	}

}
