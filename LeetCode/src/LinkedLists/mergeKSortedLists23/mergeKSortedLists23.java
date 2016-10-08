package LinkedLists.mergeKSortedLists23;

import java.util.PriorityQueue;

import LinkedLists.ListNode;

import java.util.Comparator;

public class mergeKSortedLists23 {
	/*
	 * 1. 
	 * Iterate through all the lists and merge the lists: O(N^2)
	 * 2.
	 * MinHeap solution with all the nodes:O(nlogn) time, O(logn) space
	 * 3.
	 * Divide and conquer: O(nlogn)
	 */
	
	static class PQsort implements Comparator<Integer> {
		 
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
	
	//MinHeap solution
	public static ListNode mergeKLists(ListNode[] lists) {
	    if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>(){
	        public int compare(ListNode l1, ListNode l2){
	            return l1.val - l2.val;
	        }
	    });
	    
	    //Dummy head;
	    ListNode head = new ListNode(0);
	    ListNode p = head;
	 
	    //Add all lists
	    for(ListNode list: lists){
	        if(list!=null) {
	            queue.offer(list);
	        }
	    } 
	    while(!queue.isEmpty()){
	    	ListNode n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null) {
	            queue.offer(n.next);
	        }
	    }
	    
	    return head.next;
		
		
	}
	
	
	
	
	
	//Divide and conquer solution
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
 
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        
        while(p1 != null && p2 != null){
        	int p1val = p1.val;
        	int p2val = p2.val;
        	if(p1val <= p2val){
        		p.next  = p1;
        		p1 = p1.next;
        	} else {
        		p.next = p2;
        		p2 = p2.next;
        		
        	}
        }
        //What if there are elements left in 1?
        while(p1 != null){
        	p.next = p1;
        }
        //What if there are elements left in 2?
        while(p2 != null){
        	p.next = p2;
        }
        p.next =null;
        return p;
	}
	public ListNode mergeKLists(ListNode[] lists, int last) {
		//Until there is one list left
		while(last != 0){
			int i = 0;
			int j = last;
			while(i < j){
				lists[i] = mergeTwoLists(lists[i], lists[j]);
				i++;
				j--;
				if(i >= j){
					last = j;
				}	
			}	
		}
		return lists[0];  
    }
}
