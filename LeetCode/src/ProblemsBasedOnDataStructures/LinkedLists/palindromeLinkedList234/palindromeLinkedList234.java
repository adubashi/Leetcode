package LinkedLists.palindromeLinkedList234;

import java.util.Stack;

import LinkedLists.ListNode;

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
	
	public static boolean isPalindromeSimple(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		
		
		ListNode cur = head;
		Stack<Integer> stk = new Stack<Integer>();
		
		while(cur != null){
			stk.push(cur.val);
			cur = cur.next;
		}
		
		cur = head;
		while(cur != null){
			if(cur.val != stk.pop()){
				return false;
			}
			cur = cur.next;
		}
		return true;
	}

}
