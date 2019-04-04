package linkedlist;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        //1. Use fast and slow pointer, to get the middle node of the list
		//2. Reverse the 2nd half of the list from the slow pointer 
		//3. Iterate through the list again and 
		ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
        
    }
    
    public  ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}

}
