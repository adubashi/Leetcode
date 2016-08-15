package LinkedLists;

public class partitionList86 {
	/*
	 * Add number less than val to the head
	 * Add numbers greater than val to the tail
	 * Traverses
	 * 
	 */
	public static ListNode partition(ListNode node, int x) {
		
		ListNode head = null;
		ListNode tail = null;
		while( node != null){
			ListNode next = node.next;
			if(node.val < x){
				//Add to the front
				node.next = head;
				head = node;
			} else {
				node.next = tail;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
		
	}

}
