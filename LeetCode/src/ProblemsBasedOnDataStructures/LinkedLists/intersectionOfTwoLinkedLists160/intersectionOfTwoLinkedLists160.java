package LinkedLists.intersectionOfTwoLinkedLists160;

import LinkedLists.ListNode;
import java.util.HashSet;

public class intersectionOfTwoLinkedLists160 {
	
	public static ListNode getIntersectionNodeSet(ListNode headA, ListNode headB){
		HashSet<ListNode> set = new HashSet<>();
		
		while(headA != null){
			set.add(headA);
			headA = headA.next;
		}
		
		while(headB != null){
			if(set.contains(headB)){
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode list1node = null;
		int firstLength = getLength(headA);
        ListNode list2node = null;
		int secondLength = getLength(headB);
		
		int lengthDifference = 0;
		
		if(firstLength > secondLength){
			lengthDifference = firstLength - secondLength;
			list1node = headA;
			list2node = headB;
		} else {
			lengthDifference = secondLength - firstLength;
			list1node = headB;
			list2node = headA;
		}
		
		while(lengthDifference > 0){
			list1node = list1node.next;
			lengthDifference--;
		}
		
		while(list1node != null && list2node != null){
			if(list1node == list2node){
				return list1node;
			} 
			list1node = list1node.next;
			list2node = list2node.next;
		}
		return null;
		
		
	}
	
	
	
	public static int getLength(ListNode head){
		int count = 0;
		ListNode n = head;
		while(n != null){
			count++;
			n = n.next;
		}
		return count;
	}

}
