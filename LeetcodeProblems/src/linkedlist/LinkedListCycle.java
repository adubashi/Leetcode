package linkedlist;

public class LinkedListCycle {
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		
		while(p1 != null && p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				return true;
			}
		}
        return false;
    }
	
	public ListNode detectCycle(ListNode head) {
        // Find the collision point if the list has a cycle
        if (head == null) return null;
         
        ListNode slow = head;
        ListNode fast = head;
         
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
             
            if (slow == fast) break;
        }
         
        // check if the list has no cycle
        if (fast == null || fast.next == null) 
            return null;
         
        // find the entrance of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
