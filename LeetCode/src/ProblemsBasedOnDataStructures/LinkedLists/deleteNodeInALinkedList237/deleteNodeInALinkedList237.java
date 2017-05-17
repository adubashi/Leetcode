package LinkedLists.deleteNodeInALinkedList237;

import LinkedLists.ListNode;

public class deleteNodeInALinkedList237 {
	
	public void deleteNode(ListNode node){
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;	
	}

}
