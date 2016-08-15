package LinkedLists;

public class removeNthNodeFromTheEndList19 {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for(int i = 0; i < n; i++){
			fast = fast.next;
		}
		//Remove 1st node
		if(fast == null){
			head = head.next;
			return head;
		}
		
		while(fast.next != null){
			slow = slow.next;
			fast =fast.next;
		}
		//Delete Node
		slow.next = slow.next.next;
		return head;	
	}

}
