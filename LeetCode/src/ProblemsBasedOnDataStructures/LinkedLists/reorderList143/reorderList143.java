package LinkedLists.reorderList143;

import LinkedLists.ListNode;

public class reorderList143 {
	
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null){
			return;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = slow.next;
		slow.next = null;// need to close first part
		// now should have two lists: head and fast
		// reverse order for second part
		second = reverseOrder(second);
		
		ListNode p1 = head;
		ListNode p2 = second;

		//merge two lists here
		while (p2 != null) {
			ListNode temp1 = p1.next;
			ListNode temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;		

			p1 = temp1;
			p2 = temp2;
		}
	}
	
	public static ListNode reverseOrder(ListNode head) {
		 
		if (head == null || head.next == null) {
			return head;
		}
 
		ListNode pre = head;
		ListNode curr = head.next;
 
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
 
		// set head node's next
		head.next = null;
 
		return pre;
	}
 
	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
}
