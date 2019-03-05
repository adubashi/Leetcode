package recursion;


public class SwapNodes {
	
	
	public static void main(String args[]) {
		
	}
	
	/*
	 * SwapPairs
	 * 
	 * BaseCase
	 * 
	 * head is null or head.next is null
	 * 
	 */
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		if(head.next.next == null) {
            ListNode next = head.next;
            head.next = null;
            next.next = head;
            return next;
        } else {
            ListNode next = head.next;
            ListNode nextNext = head.next.next;
            next.next = head;
            head.next = swapPairs(nextNext);
            return next;
        }   
    }

}
