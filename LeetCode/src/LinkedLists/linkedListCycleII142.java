package LinkedLists;

public class linkedListCycleII142 {
	
	public static ListNode hasCycle(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast){
                break;
            }
		}
		//no meeting point -- no loop
				if(fast == null || fast.next == null){
					return null;
				}
				
				/*
				 * Move slow to Head. Keep fast at meeting point
				 */
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				
				return fast;
	}

}
