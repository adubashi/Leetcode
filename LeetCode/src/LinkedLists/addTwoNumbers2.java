package LinkedLists;

public class addTwoNumbers2 {
	
	public static ListNode addTwoNumbers(ListNode head1, ListNode head2, int carry){
		if(head1 == null && head2 == null && carry == 0){
			return null;
		}
		ListNode result = new ListNode(0);
		int value = carry;
		if(head1 != null){
			value += head1.val;
		}
		if(head2 != null){
			value += head2.val;
		}
		
		result.val = carry % 10;
		
		if(head1 != null || head2 != null){
			ListNode more = addTwoNumbers(head1 == null ? null : head1.next,head2 == null ? null : head2.next,value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
		
	}
}
