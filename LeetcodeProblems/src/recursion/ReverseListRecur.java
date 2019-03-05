package recursion;

public class ReverseListRecur {
	
	public static void main(String args[]) {
		
	}
	
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next == null) {
	        return head;
		}
		//get second node    
	    ListNode second = head.next;
	    //set first's next to be null
	    head.next = null;
	    ListNode rest = reverseList(second);
		second.next = head;
		return rest;
    }
	
	public ListNode reverseList2(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}

}
