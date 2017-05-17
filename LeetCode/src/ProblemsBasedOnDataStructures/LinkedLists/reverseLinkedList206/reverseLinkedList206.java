package LinkedLists.reverseLinkedList206;

import LinkedLists.ListNode;

public class reverseLinkedList206 {
	
	public static ListNode reverseList(ListNode head) {
		
		ListNode cur = head;
		ListNode next = null;
		ListNode prev= null;
		
		//Prev keeps track of previous node
		//next keeps track of next pointer
		
		while(cur != null){
			//1. Keep track of next pointer
			next = cur.next;
			//Set next pointer of current node to the previous node.
			cur.next = prev;
			//Set the previous node the current node
			prev = cur;
			//set the current node to the next node(Traverse)
			cur = next;
		}
		head= prev;
		return head;
		
		
	}

}
