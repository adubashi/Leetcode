package ProblemsBasedOnDataStructures.LinkedLists.sortList148;


import ProblemsBasedOnDataStructures.LinkedLists.ListNode;

public class SortALinkedList {
	

	
	/*
	 * 
	 * Best method; merge sort 
	 *  method 1: sorted merge 
	 *  - sortedMerge -> takes in two nodes, and merges two sorted lists
	 *  -
	 *  method 2: merge sort 
	 *  - recursively call merge sort on the left node and the node to the right of the middle node 
	 *  - then merge the two sorted lists;
	 */
	
	//Merge two sorted linked lists recursively 
	public static ListNode merge(ListNode a, ListNode b) {

		ListNode result;
		//Base cases: if a is null, then return b, 
		if(a == null) {
			return b;
		} else if(b == null) {
			return a;
		}
		
		int left = a.val;
		int right = b.val;
		
		if(left <= right) {
			result = a;
			result.next = merge(a.next,b);
		} else {
			result = b;
			result.next = merge(a,b.next);	
		}
		return result;	
	}
	
	
	
	//Merge sorted lists:
	public static ListNode sort(ListNode h) {
		//Base case: null node or h is only one node long
		if(h == null || h.next == null) {
			return h; 
		}
		//Split the list into two pieces, then recurse
		ListNode middle = findMiddle(h);
		ListNode rightOfMiddle = middle.next;
		rightOfMiddle.next = null;
		
		ListNode left = sort(h);
		ListNode right = sort(rightOfMiddle);
		
		ListNode res = merge(left,right);
		return res;
	}
	
	
	public static ListNode findMiddle(ListNode h) {
		if(h == null) {
			return h;
		}
		
		ListNode fastpointer = h.next;
		ListNode slowpointer = h;
		
		while(fastpointer != null) {
			fastpointer = fastpointer.next;
			if(fastpointer != null) {
				slowpointer = slowpointer.next;
				fastpointer = fastpointer.next;
			}
		}
		
		return slowpointer;
	}

}
