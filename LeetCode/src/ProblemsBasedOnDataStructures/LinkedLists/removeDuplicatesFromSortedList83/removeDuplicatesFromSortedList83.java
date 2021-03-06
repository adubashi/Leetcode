package LinkedLists.removeDuplicatesFromSortedList83;

import LinkedLists.ListNode;

public class removeDuplicatesFromSortedList83 {
	
	
	
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
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		printList(n1);
		ListNode result = deleteDuplicatesRecur(n1);
		System.out.println();
		printList(result);
		
	}
	
	//If a node has the same value as it's 
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode cur  = head;       
        while(cur != null && cur.next != null){
        	if(cur.val == cur.next.val){
        		//IF the value of one node is the same as the value of the next, delete the next node
        		cur.next = cur.next.next;
        	} else {
        		//If not then traverse the list
        		cur = cur.next;
        	}
        } 
        
        return head;
        
	}
	
	public static ListNode deleteDuplicatesRecur(ListNode head){
		if(head == null || head.next == null) {
            return null;
        }
		
		if(head.val == head.next.val){
			head.next = head.next.next;
			deleteDuplicatesRecur(head);
		} else {
			deleteDuplicatesRecur(head.next);
		}
		
		return head;
	}

}
