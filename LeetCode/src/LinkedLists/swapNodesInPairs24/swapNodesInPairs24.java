package LinkedLists.swapNodesInPairs24;

import LinkedLists.ListNode;

public class swapNodesInPairs24 {
	
	
	public static ListNode swapPairs(ListNode head){
		//Add a dummy node to the front of the list
		
		//Cover edge case
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = head;
		while(current.next != null && current.next.next != null){
			ListNode t1 = current;
			current = current.next;
			t1.next = current.next;
			
			ListNode t2 = current.next.next;
			current.next.next = current;
			current.next = t2;
			
		}
		
		return dummy.next;
	}

}
