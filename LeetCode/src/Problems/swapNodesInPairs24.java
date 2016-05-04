package Problems;

public class swapNodesInPairs24 {
	
	public static ListNode swapPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		//Add a dummy node to the front
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p = h;
		
		while(p.next != null && p.next.next != null){
			//t1 to track first node
			ListNode t1 = p;
			p = p.next;
			t1.next = p.next;
			
			//t2 to track second node
			ListNode t2 = p.next.next;
			p.next.next = p;
			p.next = t2;
		}
		return h.next;
	}

}
