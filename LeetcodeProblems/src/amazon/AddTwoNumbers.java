package amazon;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersHelper(l1, l2, 0);
    }
	
	public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int cur) {
		if(l1 ==  null && l2 == null) {
			if(cur >= 1) {
				ListNode l = new ListNode(cur);
				l.next = null;
				return l;
			} else {
                return null;
            }	
		}
		
		int firstVal = 0;
		int secondVal = 0;
		if(l1 != null) {
			firstVal = l1.val;
		}
		if(l2 != null) {
			secondVal = l2.val;
		}
		
		
		int val = firstVal + secondVal + cur;
		int digit = val % 10;
		int rem = 0;
		if(val / 10 >= 1) {
		   rem = val / 10;
		}
		ListNode listNode = new ListNode(digit);
		
		if(l1 != null && l2 != null) {
			listNode.next = addTwoNumbersHelper(l1.next, l2.next, rem);	
		}  else if(l1 == null) {
			listNode.next = addTwoNumbersHelper(null, l2.next, rem);	
		}  else {
			listNode.next = addTwoNumbersHelper(l1.next, null, rem);	
		}
		return  listNode;
	}

}
