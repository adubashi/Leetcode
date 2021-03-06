package LinkedLists.mergeTwoSortedLinkedLists21;

import LinkedLists.ListNode;

public class mergeTwoSortedLinkedLists21 {
	
	
	
	public static void printList(ListNode n){
		
		while(n != null){
			System.out.print(n.val + " ->");
			n = n.next;
		}
		System.out.print("null");
	}
	
	public static void main(String args[]){
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		ListNode n5 = new ListNode(0);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(4);
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		printList(n1);
		ListNode result = mergeTwoLists(n1,n5);
		System.out.println();
		printList(result);
		
	}
	
	/*
	 * Merge two sorted linked lists 
	 * Strategy
	 * 1. Create a new node and then append the value that is the smallest while iterating through 
	 * both the linked lists
	 * 2. 
	 * 
	 */
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null){
			return null;
		}
		
		
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(p1 != null && p2 != null){
        	if(p1.val <= p2.val){
        		cur.next = p1;
        		p1 = p1.next;
        	} else {
        		cur.next = p2;
        		p2 = p2.next;
        	}
        	cur = cur.next;
        }
        
        //L1 still has some left
        while(p1 != null){
        	cur.next = p1;
        	p1 = p1.next;
        	cur = cur.next;
        }
        
        //L2 has some left
        while(p2 != null){
        	cur.next = p2;
        	p2 = p2.next;
        	cur = cur.next;
        }
        
        return newHead.next;
	}

}
