package LinkedLists.removeNthNodeFromTheEndList19;

import LinkedLists.ListNode;

public class removeNthNodeFromTheEndList19 {
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
		
		printList(n1);
		ListNode result = deleteNthFromEnd(n1,1);
		printList(result);
		
	}
	
	//Get Nth From the End node 
	public static ListNode getNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		
		int i = 1;
		while( i < n){
			first = first.next;
			i++;
		}
		
		while(first.next != null){
			first = first.next;
			second = second.next;
		}
		return second;
	}
	//Remove Nth ListNode from the list, get the N-1 node from the end and change the next pointer
	//Edge case 
	public static ListNode deleteNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		
		int i = 0;
		while( i < n){
			first = first.next;
			i++;
		}
		
		if(first == null){
			return second.next;
		}
		
		while(first.next != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}

}
