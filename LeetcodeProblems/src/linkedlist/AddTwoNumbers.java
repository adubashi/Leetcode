package linkedlist;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	
		return null;
    }
	
	public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int cur) {	
		
		if(l1 == null && l2 == null ) {
			//Edge case, last carry 
			if(cur >= 1) {
				ListNode l = new ListNode(cur);
				l.next = null;
				return l;
			}
			
			return null;
		}
		
		int firstVal = 0;
		if(l1 != null) {
			firstVal = l1.val;
		}
		
		int secondVal = 0;
		if(l2 != null) {
			secondVal = l2.val;
		}
		
		int val = firstVal + secondVal + cur;
		int digit = val % 10;
		int rem = 0;
		if(val / 10 >= 1) {
		   rem = val / 10;
		}
		ListNode newNode = new ListNode(digit);
		
		ListNode l1Pointer = null;
		if(l1 != null) {
			l1Pointer = l1.next;
		}
		
		ListNode l2Pointer = null;
		if(l2 != null) {
			l2Pointer = l2.next;
		}
		
		
		newNode.next = addTwoNumbersHelper(l1Pointer, l2Pointer, rem);	
		return newNode;
	}

}
