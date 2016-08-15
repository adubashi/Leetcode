package LinkedLists;

import java.util.Stack;

public class palindromeLinkedList234 {
	
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		Stack<Integer> stk = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stk.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		//Skip middle element
		if(fast != null){
			slow = slow.next;
		}
		while(slow != null){
			int val = stk.pop();
			int slowVal = slow.val;
			if(slowVal != val){
				return false;
			}
			slow = slow.next;
		}
		return true;
		
	}

}
