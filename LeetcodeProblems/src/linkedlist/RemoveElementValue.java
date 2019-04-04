package linkedlist;

public class RemoveElementValue {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode helper = new ListNode(0);
	    helper.next = head;
	    ListNode p = helper;
	    
		while(p.next != null) {
			if(p.next.val == val) {
					p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return helper.next;
    }
	
	public ListNode removeElements2s(ListNode head, int val) {
        while (head != null && head.val == val) {
        		head = head.next;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
            		curr.next = curr.next.next;
            } else {
            		curr = curr.next;
            }
        }
        return head;
    }

}
